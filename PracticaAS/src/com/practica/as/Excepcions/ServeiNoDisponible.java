package com.practica.as.Excepcions;

/**
 * Excepció que es dóna quan el servei extern encarregat de fer el pagament no està disponible
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class ServeiNoDisponible extends Exception {

	public ServeiNoDisponible() {}

	public ServeiNoDisponible(String message) {
		super(message);
	}
	
}
