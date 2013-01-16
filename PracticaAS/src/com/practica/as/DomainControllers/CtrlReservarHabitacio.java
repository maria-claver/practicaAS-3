package com.practica.as.DomainControllers;

import java.util.Date;
import java.util.HashSet;


import com.practica.as.DataInterface.CtrlDataFactoria;
import com.practica.as.DataLayer.CtrlViatge;
import com.practica.as.DomainModel.Pair;
import com.practica.as.DomainModel.Viatge;
import com.practica.as.Excepcions.HotelsNoLliures;

public class CtrlReservarHabitacio {

	private String dni;
	private Date dataInici;
	
	public CtrlReservarHabitacio() {
		
	}
	
	public HashSet<Pair> mostraHotelsLliures(String dni, Date dataInici) throws HotelsNoLliures {
		this.dni = dni;
		this.dataInici = dataInici;
		CtrlViatge cv = CtrlDataFactoria.INSTANCE.getCtrlViatge();
		Viatge v = cv.get(dni, dataInici);
		HashSet<Pair> llista = v.obteLlista();
		if (llista.isEmpty())  throw new HotelsNoLliures();
		return llista;
	}
	
	public float reservaHabitacio(String nomH) {
		CtrlViatge cv = CtrlDataFactoria.INSTANCE.getCtrlViatge();
		Viatge v = cv.get(dni, dataInici);
		float preuH = v.reservaHabitacio(nomH);
		cv.saveOrUpdate(v);
		return preuH;
	}
	
}
