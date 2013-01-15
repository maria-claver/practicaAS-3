package com.practica.as.Adpters;

import java.util.Date;

import src.PagamentStub;
import src.PagamentStub.Pagar;
import src.PagamentStub.PagarResponse;
import Excepcions.ServeiNoDisponible;

import com.practica.as.ServiceLocator.ServiceLocator;

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
