package com.practica.as.PresentationLayer;

import java.util.Date;
import java.util.HashSet;

import com.practica.as.DomainControllers.CtrlContractarViatge;
import com.practica.as.DomainModel.Pair;
import com.practica.as.Excepcions.ClientNoExisteix;
import com.practica.as.Excepcions.HotelsNoLliures;
import com.practica.as.Excepcions.JaTeViatge;
import com.practica.as.Excepcions.NoHiHaCiutats;
import com.practica.as.Excepcions.ServeiNoDisponible;

public class ContractarViatgeController {
	
	private CtrlContractarViatge ctrlContractarViatge = new CtrlContractarViatge();
	private ContractarViatgeView vista;
	
	public ContractarViatgeController(ContractarViatgeView vista){
		this.vista = vista;
	}
	
	public void contractar() {
		
		try {
			HashSet<Pair> ciutatsPreus = ctrlContractarViatge.obteCiutats();
			vista.mostraCiutatsIPreus(ciutatsPreus);
		} catch (NoHiHaCiutats e) {
			vista.mostraError("No hi ha ciutats");			
		}
	}
	
	public void OKenregistrarViatge(String ciutat, String dni, Date dIni, Date dFi) {
		try {
			ctrlContractarViatge.enregistraViatge(dni, dIni, dFi, ciutat);
			vista.mostraEscullPagarOReservarHabitacio();
		}catch (JaTeViatge e) {
            vista.mostraError("El client ja t� un viatge contractat per a aquestes dates");
		}catch (ClientNoExisteix e) {
			vista.mostraError("El sistema no t� cap client identificat amb aquest DNI a la base de dades");
			//e.printStackTrace();
		}
	}
	
	public void reservaHabitacio() {
		try {
			HashSet<Pair> hotelsPreus = ctrlContractarViatge.mostraHotelsLliures();
			vista.mostraHotelsIPreus(hotelsPreus);
		} catch (HotelsNoLliures e) {
			vista.mostraError("No hi ha hotels lliures");
		}
	}
	
	public void OKreservaHabitacio(String nomHotel) {
		float preuTotal = ctrlContractarViatge.reservaHabitacio(nomHotel);
		vista.mostraPagament(preuTotal);
	}
	
	public void pagament() {
		float preuVol = ctrlContractarViatge.getPreuVol();
		vista.mostraPagament(preuVol);
	}
	
	public void OKpagament(String numTargeta, Date dataCad) {
		try {
			boolean efectuat = ctrlContractarViatge.pagament(numTargeta, dataCad);
			if (efectuat) {
				vista.mostraFiContracte();	
			} else {
				vista.mostraError("Pagament no efectuat");	
			}
		} catch (ServeiNoDisponible e) {
			vista.mostraError("Servei de pagament no disponible");
		}
	}
	
	public void sortir() {
		vista.tancar();
	}

}
