package com.practica.as.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import Excepcions.JaTeViatge;

@Entity
public class Client {
	private String dni;
	private String nom;
	private String tlfn;
	private Integer nombreViatges;
	private List<Viatge> viatges;
	
	public Client() {
		nombreViatges = 0;
		viatges = new ArrayList<Viatge>();
	}

	@Id
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

	public Integer getNombreViatges() {
		return nombreViatges;
	}

	public void setNombreViatges(Integer nombreViatges) {
		this.nombreViatges = nombreViatges;
	}

	
	@OneToMany(targetEntity=Viatge.class, mappedBy="viatgePK.client", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Viatge> getViatges() {
		return viatges;
	}

	public void setViatges(List<Viatge> viatges) {
		this.viatges = viatges;
	}

	public void creaViatge(Ciutat ciutat, Date dataInici, Date dataFi) throws JaTeViatge {
		for (Viatge v : viatges) {
			boolean b = v.estaDisponible(dataInici, dataFi);
			if (!b) throw new JaTeViatge();
		}		
		// Viatge v = new Viatge(dni, ciutat, dataInici, dataFi);
		Viatge v = new Viatge(this, ciutat, dataInici, dataFi);
		nombreViatges++;
		viatges.add(v);
	}

}

