package com.practica.as.DomainModel;

public class Pair {
	private String nom;
	private float preu;
	
	public Pair(String n, float p){
		nom = n;
		preu = p;
	}
	
	public void setNom(String n){
		nom = n;
	}
	
	public void setPreu(float p){
		preu = p;
	}
	
	public String getNom() {
		return nom;
	}
	
	public float getPreu(){
		return preu;
	}
}
