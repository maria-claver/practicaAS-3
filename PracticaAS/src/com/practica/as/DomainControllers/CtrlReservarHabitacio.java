package com.practica.as.DomainControllers;

import java.util.Date;
import java.util.HashSet;

import com.practica.as.DataInterface.CtrlDataFactoria;
import com.practica.as.DataInterface.ICtrlViatge;
import com.practica.as.DomainModel.Pair;
import com.practica.as.DomainModel.Viatge;
import com.practica.as.Excepcions.HotelsNoLliures;

/**
 * Controlador de Domini del cas d'ús Reservar Habitació
 * 
 * @author Aida Albalate, Maria Claver, Borja González, Oriac Pérez, Joan Subirats
 *
 */
public class CtrlReservarHabitacio {

	private String dni;
	private Date dataInici;
	
	public CtrlReservarHabitacio() {}
	
	/**
	 * Consulta el llistat de noms i preus dels Hotels de la Ciutat del cas d'ús 
	 * que tenen Habitacions disponibles en el rang de dates del cas d'ús
	 * 
	 * @return
	 * 		Llistat de noms i preus dels Hotels disponibles
	 * @throws HotelsNoLliures
	 * 		No hi ha cap Hotel que tingui Habitacions disponibles
	 */
	public HashSet<Pair> mostraHotelsLliures(String dni, Date dataInici) throws HotelsNoLliures {
		this.dni = dni;
		this.dataInici = dataInici;
		ICtrlViatge cv = CtrlDataFactoria.INSTANCE.getCtrlViatge();
		Viatge v = cv.get(dni, dataInici);
		HashSet<Pair> llista = v.getLlista();
		if (llista.isEmpty())  throw new HotelsNoLliures();
		return llista;
	}
	
	/**
	 * Efectua la reserva d'una Habitació de l'Hotel indicat per al Viatge del cas d'ús
	 * 
	 * @param nomH
	 * 		Nom de l'Hotel on es vol fer la reserva
	 * @return
	 * 		Preu total de la reserva
	 */
	public float reservaHabitacio(String nomH) {
		ICtrlViatge cv = CtrlDataFactoria.INSTANCE.getCtrlViatge();
		Viatge v = cv.get(dni, dataInici);
		float preuH = v.reservaHabitacio(nomH);
		cv.saveOrUpdate(v);
		return preuH;
	}
	
}
