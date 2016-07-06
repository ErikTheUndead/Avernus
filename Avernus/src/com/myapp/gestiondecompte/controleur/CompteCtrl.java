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
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.metier.client.IMetierClient;
import com.myapp.gestiondecompte.metier.compte.IMetierCompte;
import com.myapp.gestiondecompte.metier.employe.IMetierEmploye;
import com.myapp.gestiondecompte.model.CompteModel;
import com.myapp.gestiondecompte.model.OperationModel;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 05.07.2016
 * VERSION : 1.0
 */

@Controller
public class CompteCtrl {

	/*
	 * ATTRIBUTS
	 */

	@Autowired
	private IMetierCompte metierCompte;

	@Autowired
	private IMetierEmploye metierEmploye;

	@Autowired
	private IMetierClient metierClient;

	Logger logger = Logger.getLogger("CompteCtrl");

	/*
	 * METHODES
	 */

	@RequestMapping(value = "compte")
	public String compte(Model model) {
		model.addAttribute("AttrCompte", metierCompte.getCompte());
		model.addAttribute("UpdateCompte", metierCompte.getCompte());
		model.addAttribute("AttrEmploye", metierEmploye.getEmploye());
		return "Compte";
	}

	@RequestMapping(value = "/getCompte")
	public String getCompte(Model model) {
		model.addAttribute("AttrCompte", metierCompte.getCompte());
		return "Compte";
	}

	@RequestMapping(value = "/getCompteId")
	public String getCompteId(CompteModel cm, Model model) throws ExceptionPerso {

		try {
			cm.setCompte(metierCompte.getCompteId(cm.getIdCompte()));
		} catch (Exception e) {
			cm.setExceptionGetCompteId(e.getMessage());
		}

		model.addAttribute("AttrCompte", metierCompte.getCompte());
		model.addAttribute("AttrCompteId", cm);
		model.addAttribute("AttrEmploye", metierEmploye.getEmploye());
		return "Compte";
	}

	@RequestMapping(value = "/supprimerCompte")
	public String supprimer(CompteModel cm, Model model) throws ExceptionPerso {
		
		try {
			metierCompte.deleteCompte(cm.getIdCompte());
		} catch (ExceptionPerso e) {
			cm.setExceptionDeleteCompte(e.getMessage());
		}
		
		model.addAttribute("AttrCompte", metierCompte.getCompte());
		model.addAttribute("AttrEmploye", metierEmploye.getEmploye());
		return "Compte";
	}

	@RequestMapping(value = "/updateCompte", method = RequestMethod.POST)
	public String update(CompteModel cm, Model model) throws ExceptionPerso {

		Compte cp = metierCompte.getCompteId(cm.getIdCompte());
		
		try {
			if (cm.getNum() != 0)
				cp.setNumCompte(cm.getNum());
			if (cm.getSolde() != 0)
				cp.setSoldeCompte(cm.getSolde());
			if (cm.getIdEmploye() == null)
				cm.setIdEmploye(cp.getClient().getIdClient());
			metierCompte.updateCompte(cp, cm.getIdEmploye());
			cm.setCompte(metierCompte.getCompteId(cm.getIdCompte()));
		} catch (ExceptionPerso e) {
			cm.setExceptionUpdateCompte(e.getMessage());
		}
		
		model.addAttribute("AttrCompteId", cm);
		model.addAttribute("AttrCompte", metierCompte.getCompte());
		model.addAttribute("AttrEmploye", metierEmploye.getEmploye());
		return "Compte";
	}

	@RequestMapping(value = "/creationCompte", method = RequestMethod.POST)
	public String creationCompte(CompteModel cm, Model model) throws ExceptionPerso {

		Compte cp = new Compte(cm.getNum(), cm.getSolde(), new Date());
		
		try {
			if (cm.getNum() != 0)
				cp.setNumCompte(cm.getNum());
			if (cm.getSolde() != 0)
				cp.setSoldeCompte(cm.getSolde());
			if (cm.getIdClient() != null)
				cp.setClient(metierClient.getClientById(cm.getIdClient()));
			cm.setCompte(metierCompte.addCompte(cp, cm.getIdClient(), cm.getIdEmploye(), cm.getIdBanque()));
		} catch (ExceptionPerso e) {
			cm.setExceptionCreateCompte(e.getMessage());
		}
		
		model.addAttribute("AttrCompteCreate", cm);
		model.addAttribute("AttrCompte", metierCompte.getCompte());
		model.addAttribute("AttrEmploye", metierEmploye.getEmploye());
		return "Compte";
	}

	@RequestMapping(value = "/getEmployeCompte")
	public String getCompteEmploye(CompteModel cm, Model model) throws ExceptionPerso {
		cm.setListeComptes(metierCompte.getCompteEmploye(cm.getIdEmploye()));
		model.addAttribute("AttrEmploye", metierEmploye.getEmploye());
		model.addAttribute("AttrCompte", metierCompte.getCompte());
		model.addAttribute("AttrCompteEmploye", cm);
		return "Compte";
	}

}
