package com.myapp.gestiondecompte.dao.compte;

import java.util.List;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Compte;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 1/07/2016
 * VERSION : 2
 * 
 */

public interface IDaoCompte {
	
	public Compte addCompte(Compte c, Long idClient, Long idEmploye, Long idBanque) throws ExceptionPerso;
	
	public void deleteCompte (Long idCompte) throws ExceptionPerso;
	
	public Compte updateCompte (Compte c, Long idClient,double solde) throws ExceptionPerso;
	
	public Compte getCompteId(Long idCompte) throws ExceptionPerso;
	
	public List<Compte> getCompte ();
	
	public List<Compte> getCompteEmploye (Long idEmploye) throws ExceptionPerso;

}
