package com.practica.as.Excepcions;

/**
 * Excepció que es dóna quan una ciutat no té hotels lliures
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class HotelsNoLliures extends Exception {

	public HotelsNoLliures(){}

	public HotelsNoLliures(String message){
		super(message);
	}
}
