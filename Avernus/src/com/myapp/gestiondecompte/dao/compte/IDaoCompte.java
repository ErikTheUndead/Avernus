package com.myapp.gestiondecompte.dao.compte;

import java.util.List;

import com.myapp.gestiondecompte.entities.Compte;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 30/06/2016
 * VERSION : 1
 * 
 */

public interface IDaoCompte {
	
	public Compte addCompte(Compte c, Long idClient, Long idEmploye, Long idBanque);
	
	public void deleteCompte (Long idCompte);
	
	public Compte updateCompte (Compte c);
	
	public List<Compte> getCompte ();
	
	public List<Compte> getCompteEmploye (Long idEmploye);

}
