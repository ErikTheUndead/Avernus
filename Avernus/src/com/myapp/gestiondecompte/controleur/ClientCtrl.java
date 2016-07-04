package com.myapp.gestiondecompte.controleur;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.metier.client.IMetierClient;

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

	@RequestMapping(value="/saveClient",method=RequestMethod.POST)
	public String save(Model model,
		@RequestParam("nom")   String nomClient,
		@RequestParam("prenom")   String prenomClient,
		@RequestParam("dateN")   Date DateNClient,
		@RequestParam("adresseClient") String addresseClient) {
		Client c = new Client(nomClient, prenomClient, DateNClient ,addresseClient );
		metier.addClient(c);
		model.addAttribute("AttrClient",metier.getClients());
		
		return "Client";
	}
	@RequestMapping(value="/getClientsMc")
	public String getClientByMc(Model model,String motCle) throws ExceptionPerso{
		model.addAttribute("AttrClient",metier.getClientsByMc(motCle));
		return "Client";
	}
	@RequestMapping(value="/getClients")
	public String getClient(Model model) throws ExceptionPerso{
		model.addAttribute("AttrClient",metier.getClients());
		return "Client";
	}
	@RequestMapping(value="/supprimerClient")
	public String supprimmer(Model model, Long idClient) throws ExceptionPerso{
		metier.deleteClient(idClient);
		model.addAttribute("AttrClient",metier.getClients());
		return "Client";
	}
	@RequestMapping(value="/updateClient", method=RequestMethod.POST)
	public String update(Model model, Long idClient,
			@RequestParam("nom")   String nomClient,
			@RequestParam("prenom")   String prenomClient,
			@RequestParam("dateN")   Date dateNClient,
			@RequestParam("adresseClient") String adresseClient) throws ExceptionPerso{
		
		
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
		model.addAttribute("AttrClient",metier.getClients());
		return "Client";
	}
}
