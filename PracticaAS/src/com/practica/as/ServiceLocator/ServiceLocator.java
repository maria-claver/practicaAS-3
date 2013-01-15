package com.practica.as.ServiceLocator;

import com.practica.as.Excepcions.ServeiNoDisponible;
import com.practica.as.ServeiDePagamentClient.PagamentStub;


public enum ServiceLocator {
	// SINGLETON
	INSTANCE;

	public Object find(String name) throws ServeiNoDisponible {
		try {
			if (name.equals("Pagament")) return new PagamentStub();
			else throw new ServeiNoDisponible(); 
		} catch (Exception e) {
			throw new ServeiNoDisponible();
		}
	}
}
