package com.practica.as.DomainModel;

/**
 * Classe auxiliar de tipus de dades utilitzat al Domini 
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class Pair {
	private String nom;
	private float preu;
	
	public Pair(String n, float p){
		nom = n;
		preu = p;
	}
	
	public String getNom() {return nom;}
	public void setNom(String n) {nom = n;}
	
	public void setPreu(float p) {preu = p;}
	public float getPreu() {return preu;}
}
