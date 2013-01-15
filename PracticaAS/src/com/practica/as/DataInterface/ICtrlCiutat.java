package com.practica.as.DataInterface;

import java.util.List;

import com.practica.as.DomainModel.Ciutat;

public interface ICtrlCiutat {
	
	public List<Ciutat> tots();
	public Ciutat get(String nom);
	
}
