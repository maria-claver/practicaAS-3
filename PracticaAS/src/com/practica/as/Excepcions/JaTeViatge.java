package com.practica.as.Excepcions;

/**
 * Excepci� que es d�na quan un client ja t� contractat un viatge que es solapa amb les dates indicades
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class JaTeViatge extends Exception {
	
	public JaTeViatge(){}
	
	public JaTeViatge(String message){
		super(message);
	}
}
