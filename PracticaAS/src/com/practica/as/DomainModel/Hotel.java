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


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Check(constraints="preu>0")
public class Hotel {
	
	private CmpKeyHotel hotelPK;
	private float preu;
	private List<Habitacio> habitacions = new ArrayList<Habitacio>();

	@Id
	public CmpKeyHotel getHotelPK() {
		return hotelPK;
	}
	public void setHotelPK(CmpKeyHotel hotelPK) {
		this.hotelPK = hotelPK;
	}

	@OneToMany(targetEntity=Habitacio.class, mappedBy="habitacioPK.hotel", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Habitacio> getHabitacions() {
		return habitacions;
	}
	public void setHabitacions(List<Habitacio> habitacions) {
		this.habitacions = habitacions;
	}
	public float getPreu(){
		return preu;
	}
	@Transient
	public float getPreu(Date di, Date df) {
		float r = getSuplement();
		int dies = (df.getYear() - di.getYear())*365 + (df.getMonth() - di.getMonth())*30 + (df.getDate() - di.getDate());
		return (preu + r) * dies;
	}
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	@Transient
	public String getNom() {
		return hotelPK.getNom();
	}
	
	@Transient
	public Integer getNumHabDisponible(Date di, Date df) {
		Integer aux = null;
		for (int i=0; i < habitacions.size() && aux == null; i++) {
			Habitacio h = habitacions.get(i);
			aux = h.disponible(di, df);
		}
		return aux;
	}
	
	@Transient
	public float getSuplement() {
		return 0;
	}
	
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
