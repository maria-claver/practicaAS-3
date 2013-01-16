package com.practica.as.DomainModel;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Check;



@Entity
@Check(constraints = "dataFi > dataInici")
public class Viatge {

	private CmpKeyViatge viatgePK;
	private Date dataFi;
	private Ciutat ciutat;

	public Viatge(){}
	
	public Viatge(Client client, Ciutat ciutat, Date dataIni, Date dataFi) {
		this.dataFi = dataFi;
		this.viatgePK = new CmpKeyViatge();
		this.viatgePK.setDataInici(dataIni);
		this.viatgePK.setClient(client);
		this.ciutat = ciutat;
	}

	@Id
	public CmpKeyViatge getViatgePK() {
		return viatgePK;
	}
	public void setViatgePK(CmpKeyViatge viatgePK) {
		this.viatgePK = viatgePK;
	}

	@Transient
	public Date getDataInici() {
		return viatgePK.getDataInici();
	}
	@Transient
	public void setDataInici(Date dataInici) {
		this.viatgePK.setDataInici(dataInici);
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDataFi() {
		return dataFi;
	}
	public void setDataFi(Date dataFi) {
		this.dataFi = dataFi;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(nullable=false)
	public Ciutat getCiutat() {
		return ciutat;
	}
	public void setCiutat(Ciutat ciutat) {
		this.ciutat = ciutat;
	}

	public boolean estaDisponible(Date di, Date df) {
		return getDataInici().after(df) && dataFi.before(di); 
	}

	public float reservaHabitacio(String nomH) {
		float preuH = ciutat.reservaHabitacio(nomH, this, getDataInici(), dataFi);
		return preuH;
	}

	public HashSet<Pair> obteLlista() {
		HashSet<Pair> llista = ciutat.getLlista(getDataInici(), dataFi);
		return llista;
	}
		
}
