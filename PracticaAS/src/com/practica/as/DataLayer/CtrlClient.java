package com.practica.as.DataLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practica.as.DataInterface.ICtrlClient;
import com.practica.as.DomainModel.Client;
import com.practica.as.Excepcions.ClientNoExisteix;

/**
 * Controlador de Client de la capa de dades
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public class CtrlClient implements ICtrlClient {

	public Client get(String dni) throws ClientNoExisteix {
		try {
			SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
			Session session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Client q = (Client) session.get(Client.class, dni);
			tx.commit();
			return q;
		} catch (Exception e) {
			throw new ClientNoExisteix();
		}
	}

	public void saveOrUpdate(Client client) {
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(client);
		session.getTransaction().commit();
	}

}
