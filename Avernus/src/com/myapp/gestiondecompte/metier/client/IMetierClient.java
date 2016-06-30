package com.myapp.gestiondecompte.metier.client;

import java.util.List;

import com.myapp.gestiondecompte.entities.Client;

public interface IMetierClient {

	public Client addClient(Client c);
	public void deleteClient(Long idC);
	public Client updateClient(Client c);
	public List<Client> getClients();
	public List<Client> getClientsByMc(String mc);
}
