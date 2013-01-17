package com.practica.as.DataInterface;

import java.util.Date;

import com.practica.as.DomainModel.Viatge;

/**
 * Interfície del controlador de Viatge de la capa de dades
 * 
 * @author Aida Albalate, Maria Claver, Borja González, Oriac Pérez, Joan Subirats
 *
 */
public interface ICtrlViatge {
	
	/**
	 * Retorna un viatge amb el dni i dataInici indicats
	 * 
	 * @param dni
	 * 		Dni del client que realitza el viatge
	 * @param dataInici
	 * 		Data d'inici del viatge
	 * @return
	 * 		Objecte Viatge identificat amb dni i dataInici
	 */
	public Viatge get(String dni, Date dataInici);
	
	/**
	 * Indica que s'han de passar a la base de dades els canvis efectuats al viatge indicat,
	 * ja sigui un objecte viatge nou o modificat
	 * 
	 * @param viatge
	 * 		Objecte Viatge que es vol crear o guardar a la base de dades
	 */
	public void saveOrUpdate(Viatge viatge);

}
