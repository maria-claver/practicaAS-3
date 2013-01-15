package com.practica.as.ServiceLocator;

import src.PagamentStub;
import Excepcions.ServeiNoDisponible;

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
