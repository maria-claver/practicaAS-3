package com.practica.as.Excepcions;

/**
 * Excepció que es dóna quan no existeix el client demanat
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class ClientNoExisteix extends Exception {

	public ClientNoExisteix(){}

	public ClientNoExisteix(String message){
		super(message);
	}
}
