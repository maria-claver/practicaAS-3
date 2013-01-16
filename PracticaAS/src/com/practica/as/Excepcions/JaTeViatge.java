package com.practica.as.Excepcions;

/**
 * Excepció que es dóna quan un client ja té contractat un viatge que es solapa amb les dates indicades
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class JaTeViatge extends Exception {
	
	public JaTeViatge(){}
	
	public JaTeViatge(String message){
		super(message);
	}
}
