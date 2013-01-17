package com.practica.as.DataLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practica.as.DataInterface.ICtrlClient;
import com.practica.as.DomainModel.Client;
import com.practica.as.Excepcions.ClientNoExisteix;

/**
 * Controlador de Client de la capa de dades
 * 
 * @author Aida Albalate, Maria Claver, Borja González, Oriac Pérez, Joan Subirats
 *
 */
public class CtrlClient implements ICtrlClient {

	public Client get(String dni) throws ClientNoExisteix {
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Client q = (Client) session.get(Client.class, dni);
		tx.commit();
		if (q == null) 	
			throw new ClientNoExisteix();
		return q;
	
	}

	public void saveOrUpdate(Client client) {
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.merge(client);
		session.getTransaction().commit();
	}

}
