package com.practica.as.DataInterface;

import com.practica.as.DataLayer.CtrlCiutat;
import com.practica.as.DataLayer.CtrlClient;
import com.practica.as.DataLayer.CtrlViatge;

/**
 * Factoria dels controladors de la capa de dades
 * @author Aida Albalate, Maria Claver, Borja Gonzalez, Oriac Perez, Joan Subirats
 *
 */
public enum CtrlDataFactoria {
	// SINGLETON

	INSTANCE;
	private ICtrlCiutat ctrlCiutat = new CtrlCiutat();
	private ICtrlClient ctrlClient = new CtrlClient();
	private ICtrlViatge ctrlViatge = new CtrlViatge();
	
	public ICtrlClient getCtrlClient() {
		return ctrlClient;
	}
	
	public ICtrlCiutat getCtrlCiutat() {
		return ctrlCiutat;
	}

	public ICtrlViatge getCtrlViatge() {
		return ctrlViatge;
	}
	
}
