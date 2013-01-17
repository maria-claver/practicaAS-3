package com.practica.as;

import java.awt.EventQueue;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

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

/**
 * 
 * @author Aida Albalate, Maria Claver, Borja González, Oriac Pérez, Joan Subirats
 *
 */
public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("no args");
			//omplirDBDefault();
		} else {
			System.out.println("args: " + args[0]);
		}
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
	}
	
	private static void omplirDBDefault() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Hotel.class);
		config.addAnnotatedClass(HotelSuperior.class);
		config.addAnnotatedClass(HotelLowCost.class);
		config.addAnnotatedClass(Habitacio.class);
		config.addAnnotatedClass(Client.class);
		config.addAnnotatedClass(Viatge.class);
		config.addAnnotatedClass(Ciutat.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		// insertar ciutats
		Ciutat venecia = new Ciutat ();
		venecia.setNom("Venecia");
		venecia.setDescripcio("Canales");
		venecia.setPreuVol(100);
		session.save(venecia);

		Ciutat paris = new Ciutat ();
		paris.setNom("Paris");
		paris.setDescripcio("Luz");
		paris.setPreuVol(70);
		session.save(paris);
		
		
		
		// insertar clients
		Client maria = new Client();
		maria.setDni("12345678Z");
		maria.setNom("Maria");
		session.save(maria);
		
		Client aida = new Client();
		aida.setDni("87654321X");
		aida.setNom("Aida");
		session.save(aida);
		
		// insertar hotels
		CmpKeyHotel hotel1PK = new CmpKeyHotel();
		hotel1PK.setCiutat(venecia);
		hotel1PK.setNom("Hotel Giovanni");
		Hotel hotel1 = new Hotel();
		hotel1.setHotelPK(hotel1PK);
		hotel1.setPreu(50);
		session.save(hotel1);
		
		CmpKeyHotel hotel2PK = new CmpKeyHotel();
		hotel2PK.setCiutat(venecia);
		hotel2PK.setNom("Hotel Giuseppe");
		Hotel hotel2 = new Hotel();
		hotel2.setHotelPK(hotel2PK);
		hotel2.setPreu(80);
		session.save(hotel2);

		// insertar habitacions
		CmpKeyHabitacio hab1PK = new CmpKeyHabitacio();
		hab1PK.setHotel(hotel1);
		hab1PK.setNumero(101);
		Habitacio hab1 = new Habitacio();
		hab1.setHabitacioPK(hab1PK);
		session.save(hab1);

		session.getTransaction().commit();		
	}

}
