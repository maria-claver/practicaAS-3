package com.practica.as.Adapters;

import java.util.Date;

import com.practica.as.Excepcions.ServeiNoDisponible;

/**
 * Interf�cie de l'adaptador del servei extern de pagament 
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonz�lez, Oriac P�rez, Joan Subirats
 *
 */
public interface IAdaptadorAutoritza {

	/**
	 * Efectua el pagament a trav�s del servei extern de pagament
	 * 
	 * @param dni
	 * 		Dni del Client
	 * @param numT
	 * 		N�mero de targeta de cr�dit del Client
	 * @param importTotal
	 * 		Import total a pagar
	 * @param dC
	 * 		Data de caducitat de la targeta de cr�dit
	 * @param dAvui
	 * 		Data actual en el moment d'efectuar-se el pagament
	 * @return
	 * 		Si s'ha pogut efectuar el pagament o no
	 * @throws ServeiNoDisponible
	 * 		El servei extern de pagament no est� disponible
	 */
	public boolean pagament(String dni, String numT, float importTotal, Date dC, Date dAvui) throws ServeiNoDisponible;
	
}
