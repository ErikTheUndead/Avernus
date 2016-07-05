package com.myapp.gestiondecompte.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.metier.banque.IMetierBanque;
import com.myapp.gestiondecompte.model.BanqueModel;


@Controller
public class BanqueCtrl {

	@Autowired
    private IMetierBanque metier;
	
	@RequestMapping(value = "/indexBanque")
	public String index(){
		return "Banque";
	}
	
	@RequestMapping(value = "/getBanques",method =RequestMethod.GET)
	public String getBanques(BanqueModel bm,Model model){	
		List<Banque> tabB = metier.getBanques();
		bm.setBanques(tabB);
		model.addAttribute("BanqueModel", bm);
		return "Banque";
	}
	
	@RequestMapping(value = "/getBanque",method =RequestMethod.GET)
	
	public String getBanque(BanqueModel bm,Model model){
		try {
			metier.getBanque(bm.getIdBanque());
		} catch (ExceptionPerso e) {
			bm.setExceptionGetBanueById(e.getMessage());
		}
		model.addAttribute("BanqueModel", bm);
		
		return "Banque";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@RequestMapping(value="/banque")
	public String getBanques(Model model) {
		model.addAttribute("AttrBanque",metier.getBanques());
		return "Banque";
	}
	@RequestMapping(value="/getBanque")
	public String getBanque(Model model, Long idBanque) throws ExceptionPerso{
		List<Banque> tab=new ArrayList<Banque>();
		tab.add(metier.getBanque(idBanque));
		model.addAttribute("AttrBanque",tab);
		
		try {
			List<Compte> tab1= metier.getCompteBanque(idBanque);
			model.addAttribute("AttrCompte",tab1);
		} catch (Exception e) {
			
		}
		
		List<Employe> tab2= metier.getEmployeBanque(idBanque);
		model.addAttribute("AttrEmploye",tab2);
		List<Client> tab3=(metier.getClientBanque(idBanque));
		model.addAttribute("AttrClient",tab3);
		
		return "Banque";
	}*/
	
}
