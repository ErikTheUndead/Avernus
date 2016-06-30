package com.myapp.gestiondecompte.metier.compte;

import java.util.List;
import java.util.logging.Logger;

import com.myapp.gestiondecompte.entities.Compte;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 30/06/2016
 * VERSION : 1
 * 
 */

public class MetierCompteImpl implements IMetierCompte {
	
	/*
	 * ATTRIBUTS
	 */
	
	private IMetierCompte daoCompte;
	Logger logger = Logger.getLogger("MetierCompteImpl");
	
	/*
	 * GETTERS ET SETTERS
	 */
	
	public void setDao(IMetierCompte daoCompte) {
		this.daoCompte = daoCompte;
		logger.info("<----------daoCompte injected-------->");
	}
	
	/*
	 * METHODES
	 */

	@Override
	public Compte addCompte(Compte c) {
		return daoCompte.addCompte(c);
	}

	@Override
	public void deleteCompte(Long idCompte) {
		daoCompte.deleteCompte(idCompte);
	}

	@Override
	public Compte updateCompte(Compte c) {
		return daoCompte.updateCompte(c);
	}

	@Override
	public List<Compte> getCompte() {
		return daoCompte.getCompte();
	}

	@Override
	public List<Compte> getCompteEmploye(Long idEmploye) {
		return daoCompte.getCompteEmploye(idEmploye);
	}

}
