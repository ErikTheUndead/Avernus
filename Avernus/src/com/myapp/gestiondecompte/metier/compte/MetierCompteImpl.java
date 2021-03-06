package com.myapp.gestiondecompte.metier.compte;

import java.util.List;
import java.util.logging.Logger;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.dao.compte.IDaoCompte;
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
	
	private IDaoCompte daoCompte;
	Logger logger = Logger.getLogger("MetierCompteImpl");
	
	/*
	 * GETTERS ET SETTERS
	 */
	
	public void setDaoCompte(IDaoCompte daoCompte) {
		this.daoCompte = daoCompte;
		logger.info("<----------daoCompte injected-------->");
	}
	
	/*
	 * METHODES
	 */

	@Override
	public Compte addCompte(Compte c,Long idClient, Long idEmploye, Long idBanque) throws ExceptionPerso {
		return daoCompte.addCompte(c, idClient, idEmploye, idBanque);
	}

	@Override
	public void deleteCompte(Long idCompte) throws ExceptionPerso {
		daoCompte.deleteCompte(idCompte);
	}

	@Override
	public Compte updateCompte(Compte c,Long idClient) throws ExceptionPerso {
		return daoCompte.updateCompte(c,idClient);
	}

	@Override
	public List<Compte> getCompte() {
		return daoCompte.getCompte();
	}

	@Override
	public List<Compte> getCompteEmploye(Long idEmploye) throws ExceptionPerso {
		return daoCompte.getCompteEmploye(idEmploye);
	}

	@Override
	public Compte getCompteId(Long idCompte) throws ExceptionPerso {
		return daoCompte.getCompteId(idCompte);
	}

}
