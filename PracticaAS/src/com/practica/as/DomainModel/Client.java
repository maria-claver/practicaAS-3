package com.practica.as.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.practica.as.Excepcions.JaTeViatge;

/**
 * Representacio de la classe de Domini Client
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Entity
public class Client {
	private String dni;
	private String nom;
	private String tlfn;
	private int nombreViatges;
	private List<Viatge> viatges = new ArrayList<Viatge>();;
	
	@Id
	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}

	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}

	public String getTlfn() {return tlfn;}
	public void setTlfn(String tlfn) {this.tlfn = tlfn;}

	public int getNombreViatges() {return nombreViatges;}
	public void setNombreViatges(int nombreViatges) {this.nombreViatges = nombreViatges;}

	
	@OneToMany(targetEntity=Viatge.class, mappedBy="viatgePK.client", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Viatge> getViatges() {return viatges;}
	public void setViatges(List<Viatge> viatges) {this.viatges = viatges;}

	/**
	 * Crea un nou Viatge contractat per aquest Client
	 * 
	 * @param ciutat
	 * 		Objecte Ciutat on es defineix el Viatge
	 * @param dataInici
	 * 		Data d'inici del Viatge
	 * @param dataFi
	 * 		Data de fi del Viatge
	 * @throws JaTeViatge
	 * 		Aquest Client ja te un Viatge contractat en el rang de dates indicades
	 */
	public void creaViatge(Ciutat ciutat, Date dataInici, Date dataFi) throws JaTeViatge {
		for (Viatge v : viatges) {
			boolean b = v.estaDisponible(dataInici, dataFi);
			if (!b) throw new JaTeViatge();
		}		
		Viatge v = new Viatge(this, ciutat, dataInici, dataFi);
		nombreViatges++;
		viatges.add(v);
	}

}

