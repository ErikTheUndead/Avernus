package com.myapp.gestiondecompte.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.metier.employe.IMetierEmploye;

@Controller
public class EmployeCtrl {

	@Autowired
    private IMetierEmploye metier;
	
	
	@RequestMapping(value="/employe")
	public String getEmploye(Model model) {
		model.addAttribute("AttrEmploye", metier.getEmploye());
		return "Employe";
	}
	
	@RequestMapping(value="/addEmploye", method=RequestMethod.POST)
	public String save(Model model,
		@RequestParam("nomEmploye")   String nomEmploye,
		@RequestParam("codeEmploye")   String codeEmploye){
		Employe e = new Employe(nomEmploye, codeEmploye);
		metier.addEmploye(e);
		model.addAttribute("AttrEmploye",metier.getEmploye());
		return "Employe";
	}
	
	@RequestMapping(value="/delete")
	public String suprimmer(Model model, Long idEmploye) throws ExceptionPerso{
		metier.deleteEmploye(idEmploye);
		model.addAttribute("AttrEmploye", metier.getEmploye());
		return "Employe";
	}
	
}
