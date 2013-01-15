package com.practica.as.DataInterface;

import com.practica.as.DomainModel.Client;

public interface ICtrlClient {
	public Client get(String dni);
	public void saveOrUpdate(Client client);
}
