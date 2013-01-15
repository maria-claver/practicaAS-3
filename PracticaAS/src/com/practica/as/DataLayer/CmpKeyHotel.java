package com.practica.as.DataLayer;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.practica.as.DomainModel.Ciutat;
import com.practica.as.DomainModel.Client;

@Embeddable
public class CmpKeyHotel implements Serializable{

//	private String ciutat;
	private Ciutat ciutat;
	private String nom;
	
	public CmpKeyHotel(){}
	
//	public CmpKeyHotel(String ciutat, String nom) {
//		this.ciutat = ciutat;
//		this.nom = nom;
//	}
	public CmpKeyHotel(Ciutat ciutat, String nom) {
		this.ciutat = ciutat;
		this.nom = nom;
	}

//	public String getCiutat() {
//		return ciutat;
//	}
//	public void setCiutat(String ciutat) {
//		this.ciutat = ciutat;
//	}
	@ManyToOne(cascade=CascadeType.ALL)
	public Ciutat getCiutat() {
		return ciutat;
	}
	public void setCiutat(Ciutat ciutat) {
		this.ciutat = ciutat;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
