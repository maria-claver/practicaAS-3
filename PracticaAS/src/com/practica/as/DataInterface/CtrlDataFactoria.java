package com.practica.as.DataInterface;

import com.practica.as.DataLayer.CtrlCiutat;
import com.practica.as.DataLayer.CtrlClient;
import com.practica.as.DataLayer.CtrlViatge;

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
