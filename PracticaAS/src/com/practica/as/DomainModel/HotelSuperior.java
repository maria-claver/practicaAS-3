package com.practica.as.DomainModel;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.Check;

/**
 * Representacio de la classe de Domini HotelSuperior, subclasse d'Hotel
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Entity
@Check(constraints = "recarrec>0")
public class HotelSuperior extends Hotel {
	
	private float recarrec;

	public float getRecarrec() {return recarrec;}
	public void setRecarrec(float recarrec) {this.recarrec = recarrec;}
	
	@Transient
	public float getSuplement() {
		return recarrec;
	}

}
