package com.myapp.gestiondecompte.controleur;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.metier.client.IMetierClient;
import com.myapp.gestiondecompte.model.ClientModel;

/*
 *  author : BERNARD Thomas
 *   class : ClientCtrl
 *    date : 04/06/2016
 * version : 1.0.1
 */
@Controller
public class ClientCtrl {
	@Autowired
    private IMetierClient metier;
	
	@RequestMapping(value = "/indexClient")
	public String index(Model model, ClientModel cm){
		cm.setListClient(metier.getClients());
		model.addAttribute("ClientModel",cm);
		return "Client";
	}
	

	@RequestMapping(value="/saveClient",method=RequestMethod.POST)
	public String save(Model model, ClientModel cm,
		@RequestParam("nom")   String nomClient,
		@RequestParam("prenom")   String prenomClient,
		@RequestParam("dateN")   Date DateNClient,
		@RequestParam("adresseClient") String addresseClient) {
		Client c = new Client(nomClient, prenomClient, DateNClient ,addresseClient );
		metier.addClient(c);
		List<Client> list = metier.getClients();
		cm.setListClient(list);
		model.addAttribute("ClientModel",cm);
		
		return "Client";
	}
	
	@RequestMapping(value="/getClientsMc")
	public String getClientByMc(Model model,ClientModel cm,String motCle) {
		try {
			List<Client> list = metier.getClientsByMc(cm.getMotCle());
			cm.setListClientByMc(list);
		} catch (ExceptionPerso e) {
			// TODO Auto-generated catch block
			cm.setExceptionByMc(e.getMessage());
		}
		cm.setListClient(metier.getClients());
		model.addAttribute("ClientModel",cm);
		return "Client";
	}
	
	@RequestMapping(value="/getClients")
	public String getClient(Model model, ClientModel cm) {
		List<Client> list = metier.getClients();
		cm.setListClient(list);
		model.addAttribute("ClientModel",cm);
		return "Client";
	}
	
	@RequestMapping(value="/supprimerClient")
	public String supprimmer(Model model, ClientModel cm, Long idClient) {
		
		try {
			metier.deleteClient(cm.getIdClient());
		} catch (ExceptionPerso e) {
			// TODO Auto-generated catch block
			cm.setExceptionByMc(e.getMessage());
		}
		
		return "redirect:indexClient";
	}

	@RequestMapping(value="/updateClient", method=RequestMethod.POST)
	public String update(Model model, ClientModel cm , Long idClient,
			@RequestParam("nom")   String nomClient,
			@RequestParam("prenom")   String prenomClient,
			@RequestParam("dateN")   Date dateNClient,
			@RequestParam("adresseClient") String adresseClient) throws ExceptionPerso {
		
		
		Client c1 = metier.getClientById(idClient);
		if(nomClient!="")
			c1.setNomClient(nomClient);
		if(prenomClient!="")
			c1.setPrenomClient(prenomClient);
		if(dateNClient != null)
			c1.setDateDeNaissance(dateNClient);
		if(adresseClient!="")
			c1.setAdresseClient(adresseClient);
		
		metier.updateClient(c1);
		cm.setListClient(metier.getClients());
		model.addAttribute("ClientModel",cm);
		return "redirect:indexClient";
	}
	
}