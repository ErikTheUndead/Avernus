package com.myapp.gestiondecompte.controleur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.metier.compte.IMetierCompte;

@Controller
public class CompteCtrl {
	
	@Autowired
	private IMetierCompte metier;
	
	Logger logger = Logger.getLogger("CompteCtrl");
	
	@RequestMapping(value="index")
	public String index(Model model){
		return "index";
	}
	
	@RequestMapping(value="compte")
	public String compte(Model model){
		model.addAttribute("AttrCompte",metier.getCompte());
		model.addAttribute("UpdateCompte",metier.getCompte());
		return "Compte";
	}
	
	@RequestMapping(value="/getCompte")
	public String getCompte(Model model) {
		List<Compte> tabC = new ArrayList<>();
		tabC = metier.getCompte();
		model.addAttribute("AttrCompte", tabC);
		return "Compte";
	}
	
	@RequestMapping(value="/getCompteId")
	public String getCompteId(Model model, Long idCompte) throws ExceptionPerso {
		List<Compte> tabC = new ArrayList<>();
		tabC.add(metier.getCompteId(idCompte));
		model.addAttribute("AttrCompte", metier.getCompte());
		model.addAttribute("AttrCompteId", tabC);
		return "Compte";
	}
	
	@RequestMapping(value="/supprimerCompte")
	public String supprimer(Model model, Long idCompte) throws ExceptionPerso{
		metier.deleteCompte(idCompte);
		model.addAttribute("AttrCompte",metier.getCompte());
		return "Compte";
	}
	
	@RequestMapping(value="/updateCompte",method=RequestMethod.POST)
	public String update(Model model, 
			@RequestParam("idCompte") Long idCompte,
			@RequestParam("num") int num,
			@RequestParam("solde") double solde,
			@RequestParam("idClient") Long id) throws ExceptionPerso{
		
		Compte cp = metier.getCompteId(idCompte);
		if(num!=0) cp.setNumCompte(num);
		if(solde!=0) cp.setSoldeCompte(solde);
		if(id==null) id = cp.getClient().getIdClient();
		
		metier.updateCompte(cp, id);
		List<Compte> tabC = new ArrayList<>();
		tabC.add(metier.getCompteId(idCompte));
		model.addAttribute("AttrCompteId",tabC);
		model.addAttribute("AttrCompte", metier.getCompte());
		return "Compte";
	}	
	
}
