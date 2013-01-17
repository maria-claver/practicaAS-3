package com.practica.as.DataInterface;

import java.util.List;

import com.practica.as.DomainModel.Ciutat;

/**
 * Interfície del controlador de Ciutat de la capa de dades
 * 
 * @author Aida Albalate, Maria Claver, Borja González, Oriac Pérez, Joan Subirats
 *
 */
public interface ICtrlCiutat {
	
	/**
	 * Retorna un llistat amb totes les ciutats
	 * 
	 * @return
	 * 		Llista de totes les ciutats
	 */
	public List<Ciutat> tots();
	
	/**
	 * Retorna una ciutat amb el nom indicat
	 * 
	 * @param nom
	 * 		Nom de la ciutat
	 * @return
	 * 		Objecte Ciutat identificat amb nom
	 */
	public Ciutat get(String nom);
	
}
