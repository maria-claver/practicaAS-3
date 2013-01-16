package com.practica.as.DomainModel;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;


@Embeddable
public class CmpKeyHabitacio implements Serializable {
	
	private int numero;
	private Hotel hotel;

	public CmpKeyHabitacio(){}
	
	public CmpKeyHabitacio (Hotel hotel, int numero) {
		this.hotel = hotel;
		this.numero = numero;
	}
	
	@ManyToOne(targetEntity=Hotel.class, fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="nom_hotel"), @JoinColumn(name="ciutat_hotel")})
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
