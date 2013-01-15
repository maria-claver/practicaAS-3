package com.practica.as;

import java.util.Date;

import com.practica.as.DomainControllers.CtrlContractarViatge;

public class MainDePruebas {

	public static void main(String[] args) {

		CtrlContractarViatge ctrl = new CtrlContractarViatge();
		ctrl.setDni("47884326M");
		ctrl.setPreuH(10);
		ctrl.setPreuVol(10);
		Date d = new Date(2019-1900, 0, 15);
		try {
			System.out.println(ctrl.pagament("1234567890123456", d));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
////		Session session = PersistanceConfig.INSTANCE.getSession();
//		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
//		Session session = factory.getCurrentSession();
//		session.beginTransaction();
//
//		Ciutat venecia= new Ciutat ();
//		venecia.setNom("Venecia");
//		venecia.setDescripcio("Canales");
//		venecia.setPreuVol(5);
//		
//		Ciutat Paris= new Ciutat ();
//		Paris.setNom("Paris");
//		Paris.setDescripcio("Amor");
//		Paris.setPreuVol(10);
//		
//		session.save(venecia);
//		session.save(Paris);
//		
//		Client pepe = new Client();
//		pepe.setDni("4356");
//		pepe.setNom("PEPE");
//		
//		session.save(pepe);
//		
//		session.getTransaction().commit();		
//		
//		CtrlContractarViatge ctrl = new CtrlContractarViatge();
//		try {
//			ctrl.obteCiutats();
//			
//			Date d1 = new Date();
//			System.out.println(d1);
//			Date d2 = new Date();
//			d2.setYear(2014-1900);
//			System.out.println(d2);
//			ctrl.enregistraViatge("4356", d1, d2, "Venecia");
////			session = PersistanceConfig.INSTANCE.getSession();
//			session = factory.getCurrentSession();
//			Transaction tx = session.beginTransaction();
//			
//			CtrlClient cc = CtrlDataFactoria.INSTANCE.getCtrlClient();
//			Client c = cc.get("4356");
//
//			System.out.println(c.getDni());
//			System.out.println(c.getNom());
//			System.out.println(c.getNombreViatges());
//			List<Viatge> viatges = c.getViatges();
//			System.out.println(viatges.size());
//			for (Viatge v : viatges) {
//				System.out.print(v.getDataInici() + " ");
//				System.out.print(v.getDataFi() + " ");
//				System.out.print(v.getCiutat().getNom() + " ");
//				System.out.print(v.getViatgePK().getClient().getDni());
//			}
//		} catch (NoHiHaCiutats e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JaTeViatge e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//

		
		//		
//		// Session per provar setters:
//		
//		Session session = factory.getCurrentSession();
//		session.beginTransaction();
		
//		Ciutat ciutat = new Ciutat();
//		ciutat.setNom("ciutat");
//		ciutat.setPreuVol(200);
//		
//		CmpKeyHotel h1PK = new CmpKeyHotel();
//		h1PK.setCiutat(ciutat);
//		h1PK.setNom("hotel1");
//		
//		Hotel h1 = new Hotel();
//		h1.setHotelPK(h1PK);
//		h1.setPreu(100);
//		
//		Client c1 = new Client();
//		c1.setDni("dni1");
//		c1.setNom("nom1");
//		c1.setNombreViatges(1);
//		c1.setTlfn("tlfn1");
//		
//		Date d2 = new Date();
//		d2.setYear(2011);
//		Date d3 = new Date();
//		d3.setYear(2013);
//		d2.setDate(1);
//		d3.setDate(2);
//		Viatge v1 = new Viatge(c1, ciutat, d2, d3);
//		Date d = new Date();
//		d.setYear(2012);
//		Date d1 = new Date();
//		d1.setYear(2013);
//		d.setDate(1);
//		d.setDate(2);
//		Viatge v2 = new Viatge(c1, ciutat, d, d1);
//		
//		session.save(ciutat);
//		session.save(h1);
//		session.save(c1);
//		session.save(v1);
//		session.save(v2);
//		
//		Hotel hotel1 = new Hotel();
//		CmpKeyHotel hotelKey1 = new CmpKeyHotel(ciutat, "Marina");
//		hotel1.setHotelPK(hotelKey1);
//		hotel1.setPreu(100);
//		
//		HotelLowCost hotel2 = new HotelLowCost();
//		CmpKeyHotel hotelKey2 = new CmpKeyHotel(ciutat, "Marina2");
//		hotel2.setHotelPK(hotelKey2);
//		hotel2.setPreu(200);
//		hotel2.setDescompte(20);
//
//		HotelSuperior hotel3 = new HotelSuperior();
//		CmpKeyHotel hotelKey3 = new CmpKeyHotel(ciutat, "City");
//		hotel3.setHotelPK(hotelKey3);
//		hotel3.setPreu(300);
//		hotel3.setRecarrec(30);
//
//		session.save(hotel1);
//		session.save(hotel2);
//		session.save(hotel3);
//		
//		Habitacio habi1 = new Habitacio();
//		CmpKeyHabitacio habiPK1 = new CmpKeyHabitacio(hotel1, 101);
//		habi1.setHabitacioPK(habiPK1);
//
//		Habitacio habi2 = new Habitacio();
//		CmpKeyHabitacio habiPK2 = new CmpKeyHabitacio(hotel2, 202);
//		habi2.setHabitacioPK(habiPK2);
//
//		Habitacio habi3 = new Habitacio();
//		CmpKeyHabitacio habiPK3 = new CmpKeyHabitacio(hotel3, 303);
//		habi3.setHabitacioPK(habiPK3);
//
//		session.save(habi1);
//		session.save(habi2);
//		session.save(habi3);
//		
//		habi1.setViatge(v1);
//		habi2.setViatge(v2);
//	
//		
//		session.getTransaction().commit();
//		
//		session = factory.getCurrentSession();
//		session.beginTransaction();		
//		
//		Client c2 = (Client) session.get(Client.class, "dni1");
//		
//		System.out.println("HOLAAAAAAAAAAAAA");
//		System.out.println(c2.getDni());
//		for(Viatge v : c2.getViatges()) {
//			System.out.print("Viatge : ");
//			System.out.print(v.getDataInici());
//			System.out.print(v.getViatgePK().getClient().getDni());
//			System.out.print(v.getCiutat().getNom());
//			System.out.println();
//		}
//
				
//		Hotel hotel1 = new Hotel();
//		CmpKeyHotel hotelKey1 = new CmpKeyHotel("Barcelona", "Marina");
//		hotel1.setHotelPK(hotelKey1);
//		hotel1.setPreu(100);
//		
//		HotelLowCost hotel2 = new HotelLowCost();
//		CmpKeyHotel hotelKey2 = new CmpKeyHotel("Valencia", "Marina");
//		hotel2.setHotelPK(hotelKey2);
//		hotel2.setPreu(200);
//		hotel2.setDescompte(20);
//
//		HotelSuperior hotel3 = new HotelSuperior();
//		CmpKeyHotel hotelKey3 = new CmpKeyHotel("Barcelona", "City");
//		hotel3.setHotelPK(hotelKey3);
//		hotel3.setPreu(300);
//		hotel3.setRecarrec(30);
//
//		session.save(hotel1);
//		session.save(hotel2);
//		session.save(hotel3);
//		
//		Habitacio habi1 = new Habitacio();
//		CmpKeyHabitacio habiPK1 = new CmpKeyHabitacio(hotel1, 101);
//		habi1.setHabitacioPK(habiPK1);
//
//		Habitacio habi2 = new Habitacio();
//		CmpKeyHabitacio habiPK2 = new CmpKeyHabitacio(hotel2, 202);
//		habi2.setHabitacioPK(habiPK2);
//
//		Habitacio habi3 = new Habitacio();
//		CmpKeyHabitacio habiPK3 = new CmpKeyHabitacio(hotel3, 303);
//		habi3.setHabitacioPK(habiPK3);
//
//		session.save(habi1);
//		session.save(habi2);
//		session.save(habi3);
		
//		session.getTransaction().commit();

		
		// Session per provar getters:
		
//		session = factory.getCurrentSession();
//		session.beginTransaction();
//		
//		CmpKeyHotel hpk1 = new CmpKeyHotel("Barcelona", "Marina");
//		Hotel h1 = (Hotel) session.get(Hotel.class, hpk1);
//		
//		System.out.println("Hotel 1:");
//		System.out.print(h1.getHotelPK().getCiutat() + ", ");
//		System.out.print(h1.getHotelPK().getNom() + " : ");
//		System.out.print(h1.getPreu() + "€ --> [ ");
//		for (Habitacio hab : h1.getHabitacions()) {
//			System.out.print(hab.getHabitacioPK().getNumero() + " ");
//		}
//		System.out.print(" ]");
//		System.out.println();
//		
//		
//		CmpKeyHabitacio habpk1 = new CmpKeyHabitacio(h1, 101);
//		Habitacio hab1 = (Habitacio) session.get(Habitacio.class, habpk1);
//		
//		System.out.println("Habitacio 1:");
//		System.out.print(hab1.getHabitacioPK().getHotel().getHotelPK().getCiutat() + ", ");
//		System.out.print(hab1.getHabitacioPK().getHotel().getHotelPK().getNom() + ", ");
//		System.out.print(hab1.getHabitacioPK().getNumero());
//		System.out.println();
//				
//		session.getTransaction().commit();

	}

}
