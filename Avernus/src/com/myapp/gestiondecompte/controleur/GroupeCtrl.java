package com.myapp.gestiondecompte.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Groupe;
import com.myapp.gestiondecompte.metier.employe.IMetierEmploye;
import com.myapp.gestiondecompte.metier.groupe.IMetierGroupe;

@Controller
public class GroupeCtrl {
	
	
	@Autowired
	private IMetierGroupe metier;
	@Autowired
	private IMetierEmploye metier2;
	
	@RequestMapping(value="/")
	public String getGroupesEmployes(Model model) throws ExceptionPerso{
		model.addAttribute("AttrGroupe",metier.getGroupe());
		model.addAttribute("AttrEmploye", metier2.getEmploye());
		return "Groupe";
	}

	@RequestMapping(value="/getEmploye", method=RequestMethod.POST)
	public String getCompte(Model model, Long idGroupe) throws ExceptionPerso{
		model.addAttribute("AttrEmployeG",metier.getEmployesGroupe(idGroupe));
		model.addAttribute("AttrGroupe",metier.getGroupe());
		model.addAttribute("AttrEmploye", metier2.getEmploye());
		return "Groupe";
	}
	@RequestMapping(value="/addEmployeGroupe", method=RequestMethod.POST)
	public String addEmployeGroupe(Model model, Long idGroupe , Long idEmploye) throws ExceptionPerso{
		metier.addEmployeGroupe(idGroupe, idEmploye);
		model.addAttribute("AttrEmployeG",metier.getEmployesGroupe(idGroupe));
		model.addAttribute("AttrGroupe",metier.getGroupe());
		model.addAttribute("AttrEmploye", metier2.getEmploye());
		return "Groupe";
	}
	
	@RequestMapping(value="/addGroupe", method=RequestMethod.POST)
	public String saveGroupe(Model model,@RequestParam("nomGroupe")   String nomG) throws ExceptionPerso{
		Groupe g = new Groupe(nomG);
		metier.addGroupe(g);
		model.addAttribute("AttrEmployeG",metier.getEmployesGroupe(g.getIdGroupe()));
		model.addAttribute("AttrGroupe",metier.getGroupe());
		model.addAttribute("AttrEmploye", metier2.getEmploye());
		return "Groupe";
	}
	
}
