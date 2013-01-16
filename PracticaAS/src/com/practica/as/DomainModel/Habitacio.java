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

/**
 * Representacio de la classe de Domini Habitacio
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Entity
@Check (constraints = "numero > 0")
public class Habitacio {
	
	private CmpKeyHabitacio habitacioPK;
	private Set<Viatge> viatges = new HashSet<Viatge>();
	
	@Id
	public CmpKeyHabitacio getHabitacioPK() {return habitacioPK;}
	public void setHabitacioPK(CmpKeyHabitacio habitacioPK) {this.habitacioPK = habitacioPK;}
	
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
	public Set<Viatge> getViatges() {return viatges;}
	public void setViatges(Set<Viatge> viatges) {this.viatges = viatges;}
	
	@Transient
	public Integer getNumero() {return habitacioPK.getNumero();}

	/**
	 * Consulta si l'Habitacio esta disponible per un rang de dates donat
	 * 
	 * @param di
	 * 		Data d'inici del rang de dates a consultar
	 * @param df
	 * 		Data de fi del rang de dates a consultar
	 * @return
	 * 		El numero de l'Habitacio si esta disponible, null si no.
	 */
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
		
	/**
	 * Afegeix un Viatge donat a la col·leccio de reserves de l'Habitacio
	 * 
	 * @param v
	 * 		Objecte Viatge a afegir
	 */
	public void setViatge(Viatge v) {
		viatges.add(v);
	}

}
