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
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.metier.compte.IMetierCompte;

@Controller
public class CompteCtrl {
	
	@Autowired
	private IMetierCompte metier;
	
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
		model.addAttribute("AttrCompte", metier.getCompte());
		return "Compte";
	}
	
	@RequestMapping(value="/getCompteId")
	public String getCompteId(Model model, Long idCompte) throws ExceptionPerso {
		model.addAttribute("AttrCompte", metier.getCompte());
		model.addAttribute("AttrUpdateCompte", metier.getCompteId(idCompte));
		return "Compte";
	}
	
	@RequestMapping(value="/supprimerCompte")
	public String supprimer(Model model, Long idCompte) throws ExceptionPerso{
		metier.deleteCompte(idCompte);
		model.addAttribute("AttrCompte",metier.getCompte());
		return "Compte";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Model model, Long idCompte,
			@RequestParam("num") int num,
			@RequestParam("solde") double solde) throws ExceptionPerso{
		Compte cp = new Compte(num, solde, new Date());
		metier.updateCompte(cp, idCompte, solde);
		model.addAttribute("UpdateCompte",metier.getCompte());
		model.addAttribute("AttrCompte", metier.getCompte());
		return "Compte";
	}	
	
}
