package com.practica.as.Adpters;

import java.util.Date;

import Excepcions.ServeiNoDisponible;

public interface IAdaptadorAutoritza {

	public boolean pagament(String dni, String numT, float importTotal, Date dC, Date dAvui) throws ServeiNoDisponible;
	
}
