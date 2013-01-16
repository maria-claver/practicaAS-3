package com.practica.as.DomainModel;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Classe auxiliar d'Hotel: clau primaria composta
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Embeddable
public class CmpKeyHotel implements Serializable{

	private Ciutat ciutat;
	private String nom;
	
	public CmpKeyHotel(){}
	
	public CmpKeyHotel(Ciutat ciutat, String nom) {
		this.ciutat = ciutat;
		this.nom = nom;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public Ciutat getCiutat() {return ciutat;}
	public void setCiutat(Ciutat ciutat) {this.ciutat = ciutat;}

	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	
}
