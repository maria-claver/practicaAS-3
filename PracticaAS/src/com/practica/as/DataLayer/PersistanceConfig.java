package com.practica.as.DataLayer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.practica.as.DomainModel.Ciutat;
import com.practica.as.DomainModel.Client;
import com.practica.as.DomainModel.Habitacio;
import com.practica.as.DomainModel.Hotel;
import com.practica.as.DomainModel.HotelLowCost;
import com.practica.as.DomainModel.HotelSuperior;
import com.practica.as.DomainModel.Viatge;

/**
 * Configuraci� del m�dul de persist�ncia autom�tica (Hibernate)
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonz�lez, Oriac P�rez, Joan Subirats
 *
 */
public enum PersistanceConfig {
	
	// SINGLETON;
	INSTANCE;
	
	private SessionFactory factory;

	private PersistanceConfig() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Hotel.class);
		configuration.addAnnotatedClass(HotelSuperior.class);
		configuration.addAnnotatedClass(HotelLowCost.class);
		configuration.addAnnotatedClass(Habitacio.class);
		configuration.addAnnotatedClass(Client.class);
		configuration.addAnnotatedClass(Viatge.class);
		configuration.addAnnotatedClass(Ciutat.class);
		
		configuration.configure("hibernate.cfg.xml");

		// comentar on release
//		new SchemaExport(configuration).create(true, true);

		factory = configuration.buildSessionFactory();
				
	}

	public SessionFactory getFactory() {
		return factory;
	}
	
}
