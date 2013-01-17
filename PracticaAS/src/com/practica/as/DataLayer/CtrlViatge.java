package com.practica.as.DataLayer;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practica.as.DataInterface.ICtrlViatge;
import com.practica.as.DomainModel.Client;
import com.practica.as.DomainModel.CmpKeyViatge;
import com.practica.as.DomainModel.Viatge;

/**
 * Controlador de Viatge de la capa de dades
 * 
 * @author Aida Albalate, Maria Claver, Borja González, Oriac Pérez, Joan Subirats
 *
 */
public class CtrlViatge implements ICtrlViatge {
	
	public Viatge get(String dni, Date dataInici) {
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Client c = (Client) session.get(Client.class, dni);
		
		CmpKeyViatge vk = new CmpKeyViatge();
		vk.setClient(c);
		vk.setDataInici(dataInici);
		Viatge v = (Viatge) session.get(Viatge.class, vk);
		tx.commit();
		return v;
	}

	public void saveOrUpdate(Viatge viatge) {
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.merge(viatge);
		session.getTransaction().commit();
	}
	
}
