package com.practica.as.Excepcions;

/**
 * Excepci� que es d�na quan el servei extern encarregat de fer el pagament no est� disponible
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class ServeiNoDisponible extends Exception {

	public ServeiNoDisponible() {}

	public ServeiNoDisponible(String message) {
		super(message);
	}
	
}
