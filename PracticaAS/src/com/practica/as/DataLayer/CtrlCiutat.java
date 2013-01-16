package com.practica.as.DataLayer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practica.as.DataInterface.ICtrlCiutat;
import com.practica.as.DomainModel.Ciutat;

public class CtrlCiutat implements ICtrlCiutat {
	
	public List<Ciutat> tots() {
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Ciutat");
		List<Ciutat> tots = q.list();
		tx.commit();
		return tots;
	}
	
	public Ciutat get(String nom){
		SessionFactory factory = PersistanceConfig.INSTANCE.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Ciutat q = (Ciutat) session.get(Ciutat.class, nom);
		tx.commit();
		return q;
	}

}
