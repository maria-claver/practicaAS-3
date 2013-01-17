package com.practica.as.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Representacio de la classe de Domini Hotel
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Check(constraints="preu>0")
public class Hotel {
	
	private CmpKeyHotel hotelPK;
	private float preu;
	private List<Habitacio> habitacions = new ArrayList<Habitacio>();

	@Id
	public CmpKeyHotel getHotelPK() {return hotelPK;}
	public void setHotelPK(CmpKeyHotel hotelPK) {this.hotelPK = hotelPK;}

	public float getPreu() {return preu;}
	public void setPreu(float preu) {this.preu = preu;}

	@OneToMany(targetEntity=Habitacio.class, mappedBy="habitacioPK.hotel", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	public List<Habitacio> getHabitacions() {return habitacions;}
	public void setHabitacions(List<Habitacio> habitacions) {this.habitacions = habitacions;}

	@Transient
	public String getNom() {return hotelPK.getNom();}
	public void setNom(String nom) {hotelPK.setNom(nom);}
	
	/**
	 * Consulta el preu total d'una reserva en aquest Hotel incloent el suplement
	 * que correspongui segons el tipus d'Hotel que sigui
	 * 
	 * @param di
	 * 		Data d'inici de la reserva
	 * @param df
	 * 		Data de fi de la reserva
	 * @return
	 * 		Preu total de la reserva
	 */
	@Transient
	public float getPreu(Date di, Date df) {
		float r = getSuplement();
		int dies = (df.getYear() - di.getYear())*365 + (df.getMonth() - di.getMonth())*30 + (df.getDate() - di.getDate());
		return (preu + r) * dies;
	}
		
	/**
	 * Consulta el numero d'Habitacio d'alguna Habitacio d'aquest Hotel que estigui
	 * disponible en el rang de dates de la reserva
	 * 
	 * @param di
	 * 		Data d'inici de la reserva
	 * @param df
	 * 		Data de fi de la reserva
	 * @return
	 * 		Numero d'una Habitacio disponible
	 */
	@Transient
	public Integer getNumHabDisponible(Date di, Date df) {
		Integer aux = null;
		for (int i=0; i < habitacions.size() && aux == null; i++) {
			Habitacio h = habitacions.get(i);
			aux = h.disponible(di, df);
		}
		return aux;
	}
	
	/**
	 * Consulta el suplement que correspon a l'Hotel.
	 * Si l'Hotel no es de cap subtipus, es 0.
	 * Si l'Hotel es d'algun subtipus, es sobreescriu a la subclasse.
	 * 
	 * @return
	 * 		El suplement de l'Hotel.
	 */
	@Transient
	public float getSuplement() {
		return 0;
	}
	
	/**
	 * Efectua la reserva d'una Habitacio d'aquest Hotel per a un Viatge i un rang
	 * de dates donats
	 * 
	 * @param v
	 * 		Objecte Viatge que correspon a la reserva
	 * @param di
	 * 		Data d'inici de la reserva
	 * @param df
	 * 		Data de fi de la reserva
	 * @return
	 * 		Preu total de la reserva
	 */
	public float reservaHabitacio(Viatge v, Date di, Date df) {
		Integer numH = getNumHabDisponible(di, df);
		boolean fi = false;
		float preuH = 0;
		for (int i=0; i < habitacions.size() && !fi; i++) {
			Habitacio h = habitacions.get(i);
			int numero = h.getNumero();
			fi = numH == numero;
			if (fi) {
				preuH = getPreu(di, df);
				h.setViatge(v);
			}
		}
		return preuH;
	}

}
