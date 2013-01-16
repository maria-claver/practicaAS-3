package com.practica.as.DataLayer;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.practica.as.DomainModel.Ciutat;
import com.practica.as.DomainModel.Client;
import com.practica.as.DomainModel.Habitacio;
import com.practica.as.DomainModel.Hotel;
import com.practica.as.DomainModel.HotelLowCost;
import com.practica.as.DomainModel.HotelSuperior;
import com.practica.as.DomainModel.Viatge;

/**
 * Configuració del mòdul de persistència automàtica (del Hibernate) 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public enum PersistanceConfig {
	
	// SINGLETON;
	INSTANCE;
	
	private SessionFactory factory;
	private Session session;

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
		new SchemaExport(configuration).create(true, true);

		factory = configuration.buildSessionFactory();
		session = factory.getCurrentSession();
		
	}

	public Transaction getTransaction() {
		return session.beginTransaction();
	}
	
	public SessionFactory getFactory() {
		return factory;
	}
	
}
