package com.myapp.gestiondecompte.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.metier.banque.IMetierBanque;


@Controller
public class BanqueCtrl {

	@Autowired
    private IMetierBanque metier;
	
	@RequestMapping(value="/")
	public String getBanques(Model model) {
		model.addAttribute("AttrBanque",metier.getBanques());
		return "Banque";
	}
	@RequestMapping(value="/getBanque")
	public String getBanque(Model model, Long idBanque) throws ExceptionPerso{
		List<Banque> tab=new ArrayList<Banque>();
		tab.add(metier.getBanque(idBanque));
		model.addAttribute("AttrBanque",tab);
		List<Compte> tab1= metier.getCompteBanque(idBanque);
		model.addAttribute("AttrCompte",tab1);
		List<Employe> tab2= metier.getEmployeBanque(idBanque);
		model.addAttribute("AttrEmploye",tab2);
		List<Client> tab3=(metier.getClientBanque(idBanque));
		model.addAttribute("AttrClient",tab3);
		return "Banque";
	}
	
	/*@RequestMapping(value="/getCompteBanque")
	public String getCompteBanque(Model model, Long idBanque) throws ExceptionPerso{
		
		return "Banque";
	}*/
}
