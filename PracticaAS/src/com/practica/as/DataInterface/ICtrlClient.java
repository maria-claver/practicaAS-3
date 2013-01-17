package com.practica.as.DataInterface;

import com.practica.as.DomainModel.Client;
import com.practica.as.Excepcions.ClientNoExisteix;

/**
 * Interfície del controlador de Client de la capa de dades
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public interface ICtrlClient {
	
	/**
	 * Retorna un client amb el dni indicat
	 * 
	 * @param dni
	 * 		Dni del client
	 * @return
	 * 		Objecte Client identificat amb el dni
	 */
	public Client get(String dni) throws ClientNoExisteix;
	
	/**
	 * Indica que s'ha de passar a la base de dades els canvis efectuats al client indicat,
	 * ja sigui un objecte client nou o modificat
	 * 
	 * @param client
	 * 		Objecte Client que es vol crear o guardar a la base de dades
	 */
	public void saveOrUpdate(Client client);
}
