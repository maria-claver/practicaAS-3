package com.practica.as.DomainControllers;

import java.util.Date;
import java.util.HashSet;

import com.practica.as.Adapters.AdaptadorAutoritza;
import com.practica.as.Adapters.Factoria;
import com.practica.as.DataInterface.CtrlDataFactoria;
import com.practica.as.DataInterface.ICtrlCiutat;
import com.practica.as.DataInterface.ICtrlClient;
import com.practica.as.DomainModel.Ciutat;
import com.practica.as.DomainModel.Client;
import com.practica.as.DomainModel.Pair;
import com.practica.as.Excepcions.HotelsNoLliures;
import com.practica.as.Excepcions.JaTeViatge;
import com.practica.as.Excepcions.NoHiHaCiutats;
import com.practica.as.Excepcions.ServeiNoDisponible;

/**
 * Controlador de Domini del cas d'us Contractar Viatge 
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats  
 *
 */
public class CtrlContractarViatge {

	private String dni;
	private String nom;
	private Date dataInici;
	private Date dataFi;
	private float preuVol;
	private float preuH;
	private CtrlReservarHabitacio ctrlReservarHabitacio;
	private CtrlConsultarCiutats ctrlConsultarCiutats;
	
	/**
	 * Consulta el llistat de noms i preus de vol de totes les Ciutats del sistema
	 * 
	 * @return
	 * 		Llista de noms i preus de vol de les Ciutats del sistema
	 * @throws NoHiHaCiutats
	 * 		No hi ha cap Ciutat al sistema
	 */
	public HashSet<Pair> obteCiutats() throws NoHiHaCiutats {
		ctrlConsultarCiutats = new CtrlConsultarCiutats();
		HashSet<Pair> ciutats = ctrlConsultarCiutats.obteCiutats();
		return ciutats;
	}
	
	/**
	 * Crea un Viatge contractat per un Client donat a una Ciutat donada i per a un
	 * rang de dates donades
	 * 
	 * @param dni
	 * 		Dni del Client que contracta el Viatge
	 * @param dataInici
	 * 		Data d'inici del nou Viatge
	 * @param dataFi
	 * 		Data de fi del nou Viatge
	 * @param nom
	 * 		Nom de la Ciutat on es defineix el nou Viatge
	 * @throws JaTeViatge
	 * 		El Client ja te un Viatge contractat en el rang de dates indicades
	 */
	public void enregistraViatge(String dni, Date dataInici, Date dataFi, String nom) throws JaTeViatge {
		ICtrlClient cClient = CtrlDataFactoria.INSTANCE.getCtrlClient();
		ICtrlCiutat cCiutat = CtrlDataFactoria.INSTANCE.getCtrlCiutat();
		Ciutat ciutat = cCiutat.get(nom);
		Client c = cClient.get(dni);

		c.creaViatge(ciutat, dataInici, dataFi);
		cClient.saveOrUpdate(c);
		
		this.preuVol = ciutat.getPreuVol();
		this.dni = dni;
		this.dataInici = dataInici;
		this.dataFi = dataFi;
		this.nom = nom;
	}
	
	/**
	 * Consulta el llistat de noms i preus dels Hotels de la Ciutat del cas d'us 
	 * que tenen Habitacions disponibles en el rang de dates del cas d'us
	 * 
	 * @return
	 * 		Llistat de noms i preus dels Hotels disponibles
	 * @throws HotelsNoLliures
	 * 		No hi ha cap Hotel que tingui Habitacions disponibles
	 */
	public HashSet<Pair> mostraHotelsLliures() throws HotelsNoLliures {
		ctrlReservarHabitacio = new CtrlReservarHabitacio();
		HashSet<Pair> llista = ctrlReservarHabitacio.mostraHotelsLliures(dni, dataInici);
		return llista;
	}
	
	/**
	 * Efectua la reserva d'una Habitacio de l'Hotel indicat per al Viatge del cas d'us
	 * 
	 * @param nomH
	 * 		Nom de l'Hotel on es vol fer la reserva
	 * @return
	 * 		Preu total de la reserva
	 */
	public float reservaHabitacio(String nomH) {
		float preu = ctrlReservarHabitacio.reservaHabitacio(nomH);
		this.preuH = preu;
		return preuH + preuVol;
	}
	
	/**
	 * Efectua el pagament del Viatge contractat per mitja d'un servei extern de pagament
	 * 
	 * @param numTarg
	 * 		Numero de la targeta de credit del Client que contracta el Viatge
	 * @param dC
	 * 		Data de caducitat de la targeta de credit
	 * @return
	 * 		Si s'ha pogut efectuar el pagament o no
	 * @throws ServeiNoDisponible
	 * 		El servei de pagament extern no esta disponible i no es pot efectuar el pagament
	 */
	public boolean pagament(String numTarg, Date dC) throws ServeiNoDisponible {
		Date dAvui = new Date();
		float importTotal = this.preuVol + this.preuH;
		AdaptadorAutoritza aa = Factoria.INSTANCE.getAdaptadorAutoritza();
		boolean b = aa.pagament(dni, numTarg, importTotal, dC, dAvui);
		return b;
	}
	
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}

	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}

	public Date getDataInici() {return dataInici;}
	public void setDataInici(Date dataInici) {this.dataInici = dataInici;}

	public Date getDataFi() {return dataFi;}
	public void setDataFi(Date dataFi) {this.dataFi = dataFi;}

	public float getPreuVol() {return preuVol;}
	public void setPreuVol(float preuVol) {this.preuVol = preuVol;}

	public float getPreuH() {return preuH;}
	public void setPreuH(float preuH) {this.preuH = preuH;}
	
	
}
