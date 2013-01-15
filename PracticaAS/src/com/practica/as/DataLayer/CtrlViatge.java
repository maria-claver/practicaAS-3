package com.practica.as.DataLayer;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practica.as.DataInterface.ICtrlViatge;
import com.practica.as.DomainModel.Client;
import com.practica.as.DomainModel.Viatge;

public class CtrlViatge implements ICtrlViatge {
	
	public Viatge get(String dni, Date dataInici) {
//		Session session = PersistanceConfig.INSTANCE.getSession(); 
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

	public Viatge get(Client client, Date dataInici) {
//		Session session = PersistanceConfig.INSTANCE.getSession(); 
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		CmpKeyViatge vk = new CmpKeyViatge();
		vk.setClient(client);
		vk.setDataInici(dataInici);
		Viatge v = (Viatge) session.get(Viatge.class, vk);
		tx.commit();
		return v;
	}
	
	public void saveOrUpdate(Viatge viatge) {
//		Session session = PersistanceConfig.INSTANCE.getSession();
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(viatge);
		session.getTransaction().commit();
	}
	
}
