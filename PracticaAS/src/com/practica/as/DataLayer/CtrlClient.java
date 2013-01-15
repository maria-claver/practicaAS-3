package com.practica.as.DataLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practica.as.DataInterface.ICtrlClient;
import com.practica.as.DomainModel.Client;

public class CtrlClient implements ICtrlClient {

	@Override
	public Client get(String dni) {
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Client q = (Client) session.get(Client.class, dni);
		tx.commit();
		return q;
	}

	@Override
	public void saveOrUpdate(Client client) {
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(client);
		session.getTransaction().commit();
	}

}
