package com.practica.as.DataInterface;

import com.practica.as.DataLayer.CtrlCiutat;
import com.practica.as.DataLayer.CtrlClient;
import com.practica.as.DataLayer.CtrlViatge;

public enum CtrlDataFactoria {
	// SINGLETON

	INSTANCE;
	private CtrlCiutat ctrlCiutat = new CtrlCiutat();
	private CtrlClient ctrlClient = new CtrlClient();
	private CtrlViatge ctrlViatge = new CtrlViatge();
	
	public CtrlClient getCtrlClient() {
		return ctrlClient;
	}
	
	public CtrlCiutat getCtrlCiutat() {
		return ctrlCiutat;
	}
	
	public CtrlViatge getCtrlViatge() {
		return ctrlViatge;
	}
	
}
