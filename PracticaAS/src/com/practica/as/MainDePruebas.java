package com.practica.as;

import java.awt.EventQueue;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import antlr.collections.List;

import com.practica.as.DomainModel.Ciutat;
import com.practica.as.DomainModel.Client;
import com.practica.as.DomainModel.CmpKeyHabitacio;
import com.practica.as.DomainModel.CmpKeyHotel;
import com.practica.as.DomainModel.Habitacio;
import com.practica.as.DomainModel.Hotel;
import com.practica.as.DomainModel.HotelLowCost;
import com.practica.as.DomainModel.HotelSuperior;
import com.practica.as.DomainModel.Viatge;
import com.practica.as.PresentationLayer.ContractarViatgeView;

public class MainDePruebas {

	public static void main(String[] args) {
		
	
//		AnnotationConfiguration config = new AnnotationConfiguration();
//		config.addAnnotatedClass(Hotel.class);
//		config.addAnnotatedClass(HotelSuperior.class);
//		config.addAnnotatedClass(HotelLowCost.class);
//		config.addAnnotatedClass(Habitacio.class);
//		config.addAnnotatedClass(Client.class);
//		config.addAnnotatedClass(Viatge.class);
//		config.addAnnotatedClass(Ciutat.class);
//		config.configure("hibernate.cfg.xml");
//		
//		new SchemaExport(config).create(true, true);
//		
//		SessionFactory factory = config.buildSessionFactory();
//
//		
//		
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
//		Ciutat roma= new Ciutat ();
//		roma.setNom("Roma");
//		roma.setDescripcio("Gladiadores");
//		roma.setPreuVol(10);
//		
//		
//		Ciutat vic= new Ciutat ();
//		vic.setNom("Vic");
//		vic.setDescripcio("Pagesets");
//		vic.setPreuVol(60);
//		
//		Ciutat madrid= new Ciutat ();
//		madrid.setNom("Madrid");
//		madrid.setDescripcio("Una mica burricots");
//		madrid.setPreuVol(2);
//		
//		Ciutat mila= new Ciutat ();
//		mila.setNom("Milà");
//		mila.setDescripcio("Van molt a la moda");
//		mila.setPreuVol(55);
//		
//		Ciutat amsterdam= new Ciutat ();
//		amsterdam.setNom("Àmsterdam");
//		amsterdam.setDescripcio("Fumadors");
//		amsterdam.setPreuVol(100);
//		
//		Ciutat sevilla= new Ciutat ();
//		sevilla.setNom("Sevilla");
//		sevilla.setDescripcio("Lolailos");
//		sevilla.setPreuVol(4);
//		
//		Ciutat berlin= new Ciutat ();
//		berlin.setNom("Berlin");
//		berlin.setDescripcio("BeerAdicts");
//		berlin.setPreuVol(50);
//		
//		CmpKeyHotel nomH = new CmpKeyHotel(Paris, "Palace");
//		CmpKeyHotel nomH2 = new CmpKeyHotel(Paris, "Hotel Paris");
//		
//		Hotel palace = new Hotel();
//		palace.setHotelPK(nomH);
//		palace.setPreu((float)987.45);
//		
//		Hotel hparis = new Hotel();
//		hparis.setHotelPK(nomH2);
//		hparis.setPreu((float)35);
//		
//		CmpKeyHabitacio n1 = new CmpKeyHabitacio();
//		n1.setNumero(1);
//		n1.setHotel(palace);
//		
//		CmpKeyHabitacio n2 = new CmpKeyHabitacio();
//		n2.setNumero(2);
//		n2.setHotel(palace);
//
//		CmpKeyHabitacio n3 = new CmpKeyHabitacio();
//		n3.setNumero(3);
//		n3.setHotel(palace);
//
//		CmpKeyHabitacio n4 = new CmpKeyHabitacio();
//		n4.setNumero(1);
//		n4.setHotel(hparis);
//		
//		CmpKeyHabitacio n5 = new CmpKeyHabitacio();
//		n5.setNumero(2);
//		n5.setHotel(hparis);
//
//		CmpKeyHabitacio n6 = new CmpKeyHabitacio();
//		n6.setNumero(3);
//		n6.setHotel(hparis);
//		
//		Habitacio h1 = new Habitacio();
//		h1.setHabitacioPK(n1);
//		
//		Habitacio h2 = new Habitacio();
//		h2.setHabitacioPK(n2);
//		
//		Habitacio h3 = new Habitacio();
//		h3.setHabitacioPK(n3);
//		
//		Habitacio h4 = new Habitacio();
//		h4.setHabitacioPK(n4);
//		
//		Habitacio h5 = new Habitacio();
//		h5.setHabitacioPK(n5);
//		
//		Habitacio h6 = new Habitacio();
//		h6.setHabitacioPK(n6);
//		
//		ArrayList<Habitacio> l = new ArrayList<Habitacio>();
//		l.add(h1);
//		l.add(h2);
//		l.add(h3);
//		
//		/*ArrayList<Habitacio> l2 = new ArrayList<Habitacio>();
//		l2.add(h4);
//		l2.add(h5);
//		l2.add(h6);*/
//		
//		palace.setHabitacions(l);
//		//hparis.setHabitacions(l2);
//
//		session.save(Paris);
//
//		session.save(palace);
//		//session.save(hparis);
//		
//		session.save(h1);
//		session.save(h2);
//		session.save(h3);
//		/*session.save(h4);
//		session.save(h5);
//		session.save(h6);*/
//		session.save(venecia);
//		session.save(roma);
//		session.save(berlin);
//		session.save(sevilla);
//		session.save(madrid);
//		session.save(amsterdam);
//		session.save(vic);
//		session.save(mila);
//		
//		Client pepe = new Client();
//		pepe.setDni("12345678Z");
//		pepe.setNom("PEPE");
//		pepe.setNombreViatges(2);
//		
//		session.save(pepe);
//		
//		session.getTransaction().commit();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractarViatgeView pantalla = new ContractarViatgeView();
					pantalla.setTitle("Contractar Viatge");
					pantalla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	/*	CtrlContractarViatge  ctrl = new CtrlContractarViatge();
		try {
			ctrl.obteCiutats();
			Date d1 = new Date();
			long time = d1.getTime();
			System.out.println(time);
			Date d2 = new Date();
			d2.setTime(time+1);
			ctrl.enregistraViatge("4356", d1, d2, "Roma");
		} catch (NoHiHaCiutats e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JaTeViatge e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

*/
		
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
