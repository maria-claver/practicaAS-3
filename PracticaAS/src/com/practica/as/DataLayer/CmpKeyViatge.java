package com.practica.as.DataLayer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.practica.as.DomainModel.Client;

@Embeddable
public class CmpKeyViatge implements Serializable {
	
//	private String dni;
	private Client client;
	private Date dataInici;
	
	public CmpKeyViatge(){}
	
//	public CmpKeyViatge(String dni, Date dataInici) {
//		this.dni = dni;
//		this.dataInici = dataInici;
//	}
	
	public CmpKeyViatge(Client client, Date dataInici) {
		this.client = client;
		this.dataInici = dataInici;
	}

	@ManyToOne(targetEntity = Client.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	
//	@ManyToOne(targetEntity = Client.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "dni_client")
//	public String getDni() {
//		return dni;
//	}
//	public void setDni(String dni) {
//		this.dni = dni;
//	}
	@Temporal(TemporalType.DATE)
	public Date getDataInici() {
		return dataInici;
	}
	public void setDataInici(Date dataInici) {
		this.dataInici = dataInici;
	}
	
}
