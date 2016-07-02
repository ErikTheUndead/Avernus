package com.myapp.gestiondecompte.metier.banque;

import java.util.List;
import java.util.logging.Logger;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.dao.banque.IDaoBanque;
import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;
/*
 * Author: Julie Brouqu�
 * Date: 30/06/2016
 * V 1.0.0
 */
public class MetierBanqueImpl implements IMetierBanque{

	//Attributs
	
	private IDaoBanque dao;
	Logger logger = Logger.getLogger("MetierBanqueImpl");
	
	//M�thode
	
	@Override
	public Banque addBanque(Banque b) {
		// TODO Auto-generated method stub
		return dao.addBanque(b);
	}

	@Override
	public List<Employe> getEmployeBanque(Long idBanque) throws ExceptionPerso {
		// TODO Auto-generated method stub
		return dao.getEmployeBanque(idBanque);
	}

	@Override
	public List<Client> getClientBanque(Long idBanque) throws ExceptionPerso {
		// TODO Auto-generated method stub
		return dao.getClientBanque(idBanque);
	}

	@Override
	public List<Compte> getCompteBanque(Long idBanque) throws ExceptionPerso {
		// TODO Auto-generated method stub
		return dao.getCompteBanque(idBanque);
	}
	
	// Set

	public void setDao(IDaoBanque dao) {
		this.dao = dao;
		logger.info("<----------daoBanque injected-------->");
	}

	
}
