package com.practica.as.Adapters;

import java.util.Date;


import com.practica.as.Excepcions.ServeiNoDisponible;
import com.practica.as.ServeiDePagamentClient.PagamentStub;
import com.practica.as.ServeiDePagamentClient.PagamentStub.Pagar;
import com.practica.as.ServeiDePagamentClient.PagamentStub.PagarResponse;
import com.practica.as.ServiceLocator.ServiceLocator;

/**
 * Adaptador del servei extern de pagament
 * 
 * @author Aida Albalate, Maria Claver, Borja González, Oriac Pérez, Joan Subirats
 *
 */
public class AdaptadorAutoritza implements IAdaptadorAutoritza {

	public boolean pagament(String dni, String numT, float importTotal, Date dC, Date dAvui) throws ServeiNoDisponible {
		try {
			PagamentStub stub = (PagamentStub) ServiceLocator.INSTANCE.find("Pagament");
			Pagar pagament = new Pagar();
			pagament.setDataAvui(dAvui);
			pagament.setDataCad(dC);
			pagament.setDni(dni);
			pagament.setImportTotal(importTotal);
			pagament.setNumT(numT);
			PagarResponse response = stub.pagar(pagament);
			return response.get_return();
		} catch (Exception e) {
			throw new ServeiNoDisponible();
		}
	}

	
}
