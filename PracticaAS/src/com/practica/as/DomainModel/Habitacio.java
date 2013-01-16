package com.practica.as.DomainModel;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Check;


@Entity
@Check (constraints = "numero > 0")
public class Habitacio {
	
	private Set<Viatge> viatges = new HashSet<Viatge>();
	private CmpKeyHabitacio habitacioPK;
	
	@Id
	public CmpKeyHabitacio getHabitacioPK() {
		return habitacioPK;
	}
	public void setHabitacioPK(CmpKeyHabitacio habitacioPK) {
		this.habitacioPK = habitacioPK;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="Reserva",
			joinColumns={
				@JoinColumn (name="ciutat"),
				@JoinColumn (name="hotel"),
				@JoinColumn (name="habitacio")
			},
			inverseJoinColumns = {
				@JoinColumn(name="client"),
				@JoinColumn(name="data_inci"),
				})
	public Set<Viatge> getViatges() {
		return viatges;
	}
	public void setViatges(Set<Viatge> viatges) {
		this.viatges = viatges;
	}
	
	public Integer disponible(Date di, Date df) {
		boolean aux = true;
		Integer nhab = null;
		Iterator<Viatge> it = viatges.iterator();
		while(it.hasNext() && aux) {
			Viatge v = it.next();
			aux = v.estaDisponible(di, df);
		}
		if (aux) {
			nhab = getNumero();
		}
		return nhab;
	}
	
	@Transient
	public Integer getNumero() {
		return habitacioPK.getNumero();
	}
	
	public void setViatge(Viatge v) {
		viatges.add(v);
	}

}
