package com.practica.as.DataLayer;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.practica.as.DomainModel.Hotel;

@Embeddable
public class CmpKeyHabitacio implements Serializable {
	
	private int numero;
	private Hotel hotel;

	public CmpKeyHabitacio(){}
	
	public CmpKeyHabitacio (Hotel hotel, int numero) {
		this.hotel = hotel;
		this.numero = numero;
	}
	
	@ManyToOne(targetEntity=Hotel.class)
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
