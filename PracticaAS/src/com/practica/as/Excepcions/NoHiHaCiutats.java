package com.practica.as.Excepcions;

/**
 * Excepci� que es d�na quan no hi ha ciutats a la base de dades
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class NoHiHaCiutats extends Exception {
	public NoHiHaCiutats(){}

	public NoHiHaCiutats(String message){
		super(message);
	}
}
