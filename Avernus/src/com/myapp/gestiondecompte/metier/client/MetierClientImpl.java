package com.myapp.gestiondecompte.metier.client;

import java.util.List;
import java.util.logging.Logger;

import com.myapp.gestiondecompte.dao.client.IDaoClient;
import com.myapp.gestiondecompte.entities.Client;

/*
 *  author : BERNARD Thomas
 *   class : MetierClientImpl
 *    date : 30/06/2016
 * version : 1.0
 * 
 */

public class MetierClientImpl implements IMetierClient{

	
	/*Injection*/
	private IDaoClient idao;
	Logger logger = Logger.getLogger("MetierClientImpl");

	/*Setter*/

	public void setIdao(IDaoClient idao) {
		this.idao = idao;
		logger.info("la dao Client a bien �t� inject�");
	}

	
	/*impl�mentation*/
	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return idao.addClient(c);
	}

	@Override
	public void deleteClient(Long idC) {
		// TODO Auto-generated method stub
		idao.deleteClient(idC);
	}

	@Override
	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return idao.updateClient(c);
	}

	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return idao.getClients();
	}

	@Override
	public List<Client> getClientsByMc(String mc) {
		// TODO Auto-generated method stub
		return idao.getClientsByMc(mc);
	}


	@Override
	public Client getClientById(Long id) {
		// TODO Auto-generated method stub
		return idao.getClientById(id);
	}
}
