package com.myapp.gestiondecompte.metier.employe;

import java.util.List;
import java.util.logging.Logger;

import com.myapp.gestiondecompte.dao.employe.IDaoEmploye;
import com.myapp.gestiondecompte.entities.Employe;

/*
 * Author: Julie Brouqué
 * Date: 30/06/2016
 * V 1.0.0
 */
public class MetierEmployeImpl implements IMetierEmploye{

	//Attributs 
	
	private IDaoEmploye dao;
	Logger logger = Logger.getLogger("MetierEmployeImpl");
	
	//Méthode
	
	@Override
	public Employe addEmploye(Employe e) {
		// TODO Auto-generated method stub
		return dao.addEmploye(e);
	}

	@Override
	public List<Employe> getEmploye() {
		// TODO Auto-generated method stub
		return dao.getEmploye();
	}

	//Set
	
	public void setDao(IDaoEmploye dao) {
		this.dao = dao;
		logger.info("<----------daoEmploye injected-------->");
	}
}
