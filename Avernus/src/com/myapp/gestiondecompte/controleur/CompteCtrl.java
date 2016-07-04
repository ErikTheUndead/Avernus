package com.myapp.gestiondecompte.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.gestiondecompte.metier.compte.IMetierCompte;

@Controller
public class CompteCtrl {
	
	@Autowired
	private IMetierCompte metier;
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		
		return "index";
	}
			
	
}
