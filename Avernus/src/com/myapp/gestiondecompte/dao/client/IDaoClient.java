package com.myapp.gestiondecompte.dao.client;

import java.util.List;

import com.myapp.gestiondecompte.entities.Client;

/*
 *  author : BERNARD Thomas
 *   class : IDaoClient
 *    date : 30/06/2016
 * version : 1.0
 * 
 */

public interface IDaoClient {

		public Client addClient(Client c);
		public void deleteClient(Long idC);
		public Client updateClient(Client c);
		public Client getClientById(Long id);
		public List<Client> getClients();
		public List<Client> getClientsByMc(String mc);
}
