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
import com.myapp.gestiondecompte.model.GroupeModel;

@Controller
public class GroupeCtrl {
	
	
	@Autowired
	private IMetierGroupe metier;
	@Autowired
	private IMetierEmploye metier2;
	
	@RequestMapping(value="/indexGroupe")
	public String getGroupesEmployes(Model model, GroupeModel gm) throws ExceptionPerso{
		gm.setListGroupe(metier.getGroupe());
		gm.setListEmploye(metier2.getEmploye());
		model.addAttribute("GroupeModel",gm);
		return "Groupe";
	}

	@RequestMapping(value="/getEmploye", method=RequestMethod.POST)
	public String getCompte(Model model, GroupeModel gm) throws ExceptionPerso{
		try {
			gm.setListEmployeG(metier.getEmployesGroupe(gm.getIdGroupe()));
			gm.setListGroupe(metier.getGroupe());
			gm.setListEmploye(metier2.getEmploye());
		} catch (Exception e) {
			gm.setExceptionGetGroupe(e.getMessage());
		}
		model.addAttribute("GroupeModel", gm);
		return "Groupe";
	}
	@RequestMapping(value="/addEmployeGroupe", method=RequestMethod.POST)
	public String addEmployeGroupe(Model model , GroupeModel gm) throws ExceptionPerso{
		metier.addEmployeGroupe(gm.getIdGroupe(), gm.getIdEmploye());
		model.addAttribute("GroupeModel", gm);
		return "redirect:indexGroupe";
	}
	
	@RequestMapping(value="/addGroupe", method=RequestMethod.POST)
	public String saveGroupe(Model model, GroupeModel gm) throws ExceptionPerso{
		
		Groupe g = new Groupe(gm.getNomGroupe());
		metier.addGroupe(g);
		model.addAttribute("GroupeModel", gm);
		return "redirect:indexGroupe";
	}
	
}
