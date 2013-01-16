package com.practica.as;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.practica.as.DataLayer.PersistanceConfig;
import com.practica.as.DomainControllers.CtrlContractarViatge;
import com.practica.as.DomainModel.Ciutat;
import com.practica.as.DomainModel.Client;
import com.practica.as.DomainModel.CmpKeyHabitacio;
import com.practica.as.DomainModel.CmpKeyHotel;
import com.practica.as.DomainModel.Habitacio;
import com.practica.as.DomainModel.Hotel;
import com.practica.as.DomainModel.Pair;

public class MainDePruebas {

	public static void main(String[] args) {

		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Ciutat venecia= new Ciutat ();
		venecia.setNom("Venecia");
		venecia.setDescripcio("Canales");
		venecia.setPreuVol(5);
		
		session.save(venecia);
		
		Client pepe = new Client();
		pepe.setDni("47884326M");
		pepe.setNom("PEPE");
		
		session.save(pepe);
		
		CmpKeyHotel hotel1PK = new CmpKeyHotel();
		hotel1PK.setCiutat(venecia);
		hotel1PK.setNom("hotel1");
		
		Hotel hotel1 = new Hotel();
		hotel1.setHotelPK(hotel1PK);
		hotel1.setPreu(100);

		session.save(hotel1);
		
		CmpKeyHabitacio hab1PK = new CmpKeyHabitacio();
		hab1PK.setHotel(hotel1);
		hab1PK.setNumero(101);
		
		Habitacio hab1 = new Habitacio();
		hab1.setHabitacioPK(hab1PK);

		session.save(hab1);		
		
		session.getTransaction().commit();		

		CtrlContractarViatge ctrl = new CtrlContractarViatge();
		try {
			
			// obteciutats
			HashSet<Pair> ciutats = ctrl.obteCiutats();
			System.out.println("Ciutats: " + ciutats.size());
			Iterator<Pair> itc = ciutats.iterator();
			while(itc.hasNext()) {
				Pair p = itc.next();
				System.out.println("  nom: " + p.getNom());
				System.out.println("  preuvol: " + p.getPreu());
			}
			
			Date d1 = new Date();
			Date d2 = new Date();
			d2.setYear(2014-1900);
			
			// enregistraviatge
			ctrl.enregistraViatge("47884326M", d1, d2, "Venecia");

			
			// mostrahotelslliures
			HashSet<Pair> llista = ctrl.mostraHotelsLliures();
			
			Iterator<Pair> it = llista.iterator();
			System.out.println("Hotels lliures: " + llista.size());
			while (it.hasNext()) {
				Pair p = it.next();
				System.out.println(p.getNom() + ": " + p.getPreu());
			}
			
			// reservahabitacio
			ctrl.reservaHabitacio("hotel1");
			
			System.out.println("Controlador:");
			System.out.println(ctrl.getDni());
			System.out.println(ctrl.getNom());
			System.out.println(ctrl.getPreuH());
			System.out.println(ctrl.getPreuVol());
			System.out.println(ctrl.getDataFi());
			System.out.println(ctrl.getDataInici());
			
			Date dC = new Date();
			dC.setYear(2020-1900);
			boolean b = ctrl.pagament("1234567812345678", dC);
			System.out.println("Pagament: " + b);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
