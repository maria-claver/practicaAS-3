package com.practica.as.Excepcions;

/**
 * Excepci� que es d�na quan una ciutat no t� hotels lliures
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class HotelsNoLliures extends Exception {

	public HotelsNoLliures(){}

	public HotelsNoLliures(String message){
		super(message);
	}
}
