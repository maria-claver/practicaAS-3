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

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.classic.Session;

import com.practica.as.DataLayer.PersistanceConfig;

@Entity
@Table(name ="CIUTAT")
@Check(constraints = "preuvol>0")
public class Ciutat {

	private String nom;
	private String descripcio;
	private float preuVol;
	private List<Hotel> hotels = new ArrayList<Hotel>();
	
	@Id
	public String getNom(){
		return nom;
	}
	
	public float getPreuVol() {
		return preuVol;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void setPreuVol(float preuVol) {
		this.preuVol = preuVol;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	@OneToMany(targetEntity=Hotel.class, mappedBy="hotelPK.ciutat", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Transient
	public HashSet<Pair> getLlista(Date dataInici, Date dataFi){
		HashSet<Pair> llista = new HashSet<Pair>();
		
//		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
//		Session session = factory.getCurrentSession();
//		session.beginTransaction();
//		System.out.println(session.isOpen());
		
//		List<Hotel> hs = getHotels();
		
//		hs.get(0);
		
		System.out.println("MostraHotels: Ciutat");
		System.out.println(this.descripcio);
		System.out.println(this.nom);
		System.out.println(this.preuVol);
		System.out.println(this.hotels.size());
		System.out.println(this.hotels.get(0).getNom());
		
		for (Hotel h : hotels) {
			Integer r = h.getNumHabDisponible(dataInici, dataFi);
			if (r != null) {
				String nom = h.getNom();
				float preu = h.getPreu(dataInici, dataFi);
				llista.add(new Pair(nom, preu));
			}
		}
		
//		session.getTransaction().commit();
		
		return llista;
	}
	
	public float reservaHabitacio(String nomH, Viatge v, Date dataInici, Date dataFi){
		boolean fi = false;
		float preuH = 0;
		for (int i=0; i < hotels.size() && !fi; i++) {
			Hotel h = hotels.get(i);
			String nom = h.getNom();
			fi = nom == nomH;
			if (fi) {
				preuH = h.reservaHabitacio(v, dataInici, dataFi);
			}
		}
		return preuH;
	}

}
