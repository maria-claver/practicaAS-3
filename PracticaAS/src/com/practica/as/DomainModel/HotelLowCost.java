package com.practica.as.DomainModel;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.Check;

/**
 * Representacio de la classe de Domini HotelLowCost, subclasse d'Hotel 
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Entity
@Check(constraints = "descompte>0")
public class HotelLowCost extends Hotel {
	
	private float descompte;

	public float getDescompte() {return descompte;}
	public void setDescompte(float descompte) {this.descompte = descompte;}
	
	@Transient
	public float getSuplement() {
		return descompte*(-1);
	}

}
