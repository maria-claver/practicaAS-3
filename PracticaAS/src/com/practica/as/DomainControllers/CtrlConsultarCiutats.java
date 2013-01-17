package com.practica.as.DomainControllers;

import java.util.HashSet;
import java.util.List;

import com.practica.as.DataInterface.CtrlDataFactoria;
import com.practica.as.DataInterface.ICtrlCiutat;
import com.practica.as.DomainModel.Ciutat;
import com.practica.as.DomainModel.Pair;
import com.practica.as.Excepcions.NoHiHaCiutats;

/**
 * Controlador de Domini del cas d'ús Consultar Ciutats
 * 
 * @author Aida Albalate, Maria Claver, Borja González, Oriac Pérez, Joan Subirats
 *
 */
public class CtrlConsultarCiutats {

	/**
	 * Consulta el llistat de noms i preus de vol de totes les Ciutats del sistema
	 * 
	 * @return
	 * 		Llista de noms i preus de vol de les Ciutats del sistema
	 * @throws NoHiHaCiutats
	 * 		No hi ha cap Ciutat al sistema
	 */
	public HashSet<Pair> obteCiutats() throws NoHiHaCiutats {
		HashSet<Pair> resultat = new HashSet<Pair>();
		ICtrlCiutat c = CtrlDataFactoria.INSTANCE.getCtrlCiutat();
		List<Ciutat> ll = c.tots();
		if (ll.isEmpty()) throw new NoHiHaCiutats();
		for (Ciutat l : ll) {
			String nom = l.getNom();
			float preuV = l.getPreuVol();
			resultat.add(new Pair(nom, preuV));
		}
		return resultat;
	}
	
}
