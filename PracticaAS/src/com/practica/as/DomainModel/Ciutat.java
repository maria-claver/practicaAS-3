package com.practica.as.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Representació de la classe de Domini Ciutat
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Entity
@Table(name ="CIUTAT")
@Check(constraints = "preuvol>0")
public class Ciutat {

	private String nom;
	private String descripcio;
	private float preuVol;
	private List<Hotel> hotels = new ArrayList<Hotel>();
	
	@Id
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	
	public float getPreuVol() {return preuVol;}
	public void setPreuVol(float preuVol) {this.preuVol = preuVol;}

	public String getDescripcio() {return descripcio;}
	public void setDescripcio(String descripcio) {this.descripcio = descripcio;}

	@OneToMany(targetEntity=Hotel.class, mappedBy="hotelPK.ciutat", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Hotel> getHotels() {return hotels;}
	public void setHotels(List<Hotel> hotels) {this.hotels = hotels;}

	/**
	 * Consulta la llista de noms i preus dels Hotels que tenen Habitacions
	 * disponibles per a les dates del Viatge a la Ciutat
	 * 
	 * @param dataInici
	 * 		Data d'inici del Viatge
	 * @param dataFi
	 * 		Data de di del Viatge
	 * @return
	 * 		Llista de noms i preus dels Hotels disponibles
	 */
	@Transient
	public HashSet<Pair> getLlista(Date dataInici, Date dataFi){
		HashSet<Pair> llista = new HashSet<Pair>();
		for (Hotel h : hotels) {
			Integer r = h.getNumHabDisponible(dataInici, dataFi);
			if (r != null) {
				String nom = h.getNom();
				float preu = h.getPreu(dataInici, dataFi);
				llista.add(new Pair(nom, preu));
			}
		}
		return llista;
	}
	
	/**
	 * Efectua la reserva d'una Habitacio per a un Viatge d'aquesta Ciutat
	 * 
	 * @param nomH
	 * 		Nom de l'Hotel on es vol fer la reserva
	 * @param v
	 * 		Objecte Viatge per al que es fa la reserva
	 * @param dataInici
	 * 		Data d'inici de la reserva
	 * @param dataFi
	 * 		Data de fi de la reserva
	 * @return
	 * 		Preu de la reserva
	 */
	public float reservaHabitacio(String nomH, Viatge v, Date dataInici, Date dataFi){
		boolean fi = false;
		float preuH = 0;
		for (int i=0; i < hotels.size() && !fi; i++) {
			Hotel h = hotels.get(i);
			String nom = h.getNom();
			fi = nom.equals(nomH);
			if (fi) {
				preuH = h.reservaHabitacio(v, dataInici, dataFi);
			}
		}
		return preuH;
	}

}
