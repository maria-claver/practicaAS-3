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

/**
 * Representa la classe de Domini Viatge
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
@Entity
@Check(constraints = "dataFi > dataInici")
public class Viatge {

	private CmpKeyViatge viatgePK;
	private Date dataFi;
	private Ciutat ciutat;

	public Viatge(){}
	
	/**
	 * Crea un Viatge amb els atributs inicialitzats amb els valors dels parametres
	 * 
	 * @param client
	 * 		Objecte Client que contracta el Viatge
	 * @param ciutat
	 * 		Objecte Ciutat on es defineix el Viatge
	 * @param dataIni
	 * 		Data d'inici del Viatge
	 * @param dataFi
	 * 		Data de fi del Viatge
	 */
	public Viatge(Client client, Ciutat ciutat, Date dataIni, Date dataFi) {
		this.dataFi = dataFi;
		this.viatgePK = new CmpKeyViatge();
		this.viatgePK.setDataInici(dataIni);
		this.viatgePK.setClient(client);
		this.ciutat = ciutat;
	}

	@Id
	public CmpKeyViatge getViatgePK() {return viatgePK;}
	public void setViatgePK(CmpKeyViatge viatgePK) {this.viatgePK = viatgePK;}

	@Transient
	public Date getDataInici() {return viatgePK.getDataInici();}
	@Transient
	public void setDataInici(Date dataInici) {this.viatgePK.setDataInici(dataInici);}
	
	@Temporal(TemporalType.DATE)
	public Date getDataFi() {return dataFi;}
	public void setDataFi(Date dataFi) {this.dataFi = dataFi;}

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(nullable=false)
	public Ciutat getCiutat() {return ciutat;}
	public void setCiutat(Ciutat ciutat) {this.ciutat = ciutat;}

	
	/**
	 * Consulta si les dates proposades es solapen amb les dates del Viatge
	 * 
	 * @param di
	 * 		Data inicial proposada
	 * @param df
	 * 		Data final proposada
	 * @return
	 * 		Si els rangs de dates se solapen o no 
	 */
	public boolean estaDisponible(Date di, Date df) {
		return getDataInici().after(df) && dataFi.before(di); 
	}

	/**
	 * Efectua la reserva d'una Habitacio per a aquest Viatge
	 * 
	 * @param nomH
	 * 		Nom de l'Hotel on es vol fer la reservar
	 * @return
	 * 		El preu de la reserva
	 */
	public float reservaHabitacio(String nomH) {
		float preuH = ciutat.reservaHabitacio(nomH, this, getDataInici(), dataFi);
		return preuH;
	}

	/**
	 * Consulta la llista de noms i preus dels Hotels que tenen Habitacions disponibles
	 * per a les dates del Viatge a la Ciutat del Viatge
	 * 
	 * @return
	 * 		Llista de noms i preus dels Hotels disponibles
	 */
	@Transient
	public HashSet<Pair> getLlista() {
		HashSet<Pair> llista = ciutat.getLlista(getDataInici(), dataFi);
		return llista;
	}
		
}
