package com.practica.as.DomainModel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe auxiliar de Viatge: clau primaria composta 
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Embeddable
public class CmpKeyViatge implements Serializable {
	
	private Client client;
	private Date dataInici;
	
	public CmpKeyViatge(){}
	
	public CmpKeyViatge(Client client, Date dataInici) {
		this.client = client;
		this.dataInici = dataInici;
	}

	@ManyToOne(targetEntity = Client.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	public Client getClient() {return client;}
	public void setClient(Client client) {this.client = client;}

	@Temporal(TemporalType.DATE)
	public Date getDataInici() {return dataInici;}
	public void setDataInici(Date dataInici) {this.dataInici = dataInici;}
	
}
