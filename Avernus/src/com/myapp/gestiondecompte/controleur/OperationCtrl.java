package com.myapp.gestiondecompte.controleur;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.metier.compte.IMetierCompte;
import com.myapp.gestiondecompte.metier.operation.IMetierOperation;

@Controller
public class OperationCtrl {

	@Autowired
	private IMetierOperation metier;
	
	Logger logger = Logger.getLogger("OperationCtrl");
	
	@RequestMapping(value="operation")
	public String compte(Model model){
		model.addAttribute("AttrOperation",metier.getOperation());
//		model.addAttribute("UpdateCompte",metier.getCompte());
//		model.addAttribute("AttrEmploye",metier2.getEmploye());
		return "Operation";
	}
	
	@RequestMapping(value="/getOperation")
	public String getCompte(Model model) {
		model.addAttribute("AttrOperation", metier.getOperation());
		return "Operation";
	}
	
	@RequestMapping(value="/operationVersement")
	public String operationVersement(Model model,
			@RequestParam("idCompte") Long idC,
			@RequestParam("idEmploye") Long idE,
			@RequestParam("montant") double montant) {
		
		return "Operation";
		
	}
}
