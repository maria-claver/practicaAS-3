package com.practica.as.Excepcions;

/**
 * Excepci� que es d�na quan no existeix el client demanat
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class ClientNoExisteix extends Exception {

	public ClientNoExisteix(){}

	public ClientNoExisteix(String message){
		super(message);
	}
}
