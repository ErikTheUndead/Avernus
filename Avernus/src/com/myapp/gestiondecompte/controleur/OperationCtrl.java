package com.myapp.gestiondecompte.controleur;

import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.metier.operation.IMetierOperation;
import com.myapp.gestiondecompte.model.OperationModel;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 05.07.2016
 * VERSION : 1.0
 */

@Controller
public class OperationCtrl {

	/*
	 * ATTRIBUTS
	 */

	@Autowired
	private IMetierOperation metierOperation;

	Logger logger = Logger.getLogger("OperationCtrl");

	/*
	 * METHODES
	 */

	@RequestMapping(value = "/operation")
	public String compte(Model model) {
		model.addAttribute("AttrOperation", metierOperation.getOperation());
		OperationModel om = new OperationModel();
		model.addAttribute("AttrOperationRetrait", om);
		model.addAttribute("AttrOperationVersement", om);
		model.addAttribute("AttrOperationVirement", om);
		return "Operation";
	}

	@RequestMapping(value = "/getOperation")
	public String getCompte(Model model) {
		model.addAttribute("AttrOperation", metierOperation.getOperation());
		return "Operation";
	}

	@RequestMapping(value = "/operationRetrait", method = RequestMethod.POST)
	public String operationRetrait(OperationModel om, Model model) throws ExceptionPerso {

		try {
			om.setOperation(metierOperation.retrait(om.getIdCompte1(), om.getIdEmploye(), om.getMontant(), new Date()));
		} catch (ExceptionPerso e) {
			om.setExceptionRetrait(e.getMessage());
		}

		model.addAttribute("AttrOperationRetrait", om);
		model.addAttribute("AttrOperation", metierOperation.getOperation());
		return "redirect:operation";
	}

	@RequestMapping(value = "/operationVersement", method = RequestMethod.POST)
	public String operationVersement(OperationModel om, Model model) throws ExceptionPerso {

		try {
			om.setOperation(
					metierOperation.versement(om.getIdCompte1(), om.getIdEmploye(), om.getMontant(), new Date()));
		} catch (ExceptionPerso e) {
			om.setExceptionVersement(e.getMessage());
		}

		model.addAttribute("AttrOperationVersement", om);
		model.addAttribute("AttrOperation", metierOperation.getOperation());
		return "redirect:operation";
	}

	@RequestMapping(value = "/operationVirement", method = RequestMethod.POST)
	public String operationVirement(OperationModel om, Model model) throws ExceptionPerso {

		try {
			om.setListeOperations(metierOperation.virement(om.getIdCompte1(), om.getIdCompte2(), om.getIdEmploye(),
					om.getMontant(), new Date()));
		} catch (Exception e) {
			om.setExceptionVirement(e.getMessage());
		}

		model.addAttribute("AttrOperationVirement", om);
		model.addAttribute("AttrOperation", metierOperation.getOperation());
		return "redirect:operation";
	}
}
