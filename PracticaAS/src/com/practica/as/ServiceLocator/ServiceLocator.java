package com.practica.as.ServiceLocator;

import java.util.HashMap;

import com.practica.as.Excepcions.ServeiNoDisponible;
import com.practica.as.ServeiDePagamentClient.PagamentStub;

/**
 * Intermediari que busca i cacheja els serveis externs
 * 
 * @author maria
 *
 */
public enum ServiceLocator {
	// SINGLETON
	INSTANCE;
	private HashMap<String, Object> cache = new HashMap<String, Object>();

	/**
	 * Busca i obté un servei extern per nom i el cacheja per a agilitzar properes crides
	 * 
	 * @param name
	 * 		Nom del servei extern
	 * @return
	 * 		Objecte del servei extern
	 * @throws ServeiNoDisponible
	 * 		El servei extern no està disponible
	 */
	public Object find(String name) throws ServeiNoDisponible {
		try {
			 if (cache.containsKey(name)){
				  return cache.get(name);
			 } else {
				 if (name.equals("Pagament")) {
					 Object ob = new PagamentStub();
					 cache.put(name, ob);
					 return ob;  
				 } else
					 throw new ServeiNoDisponible();
			 }
		} catch (Exception e) {
			throw new ServeiNoDisponible();
		}
	}
}
