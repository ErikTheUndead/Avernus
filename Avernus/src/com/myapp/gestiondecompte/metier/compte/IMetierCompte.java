package com.myapp.gestiondecompte.metier.compte;

import java.util.List;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Compte;

public interface IMetierCompte {
	
	public Compte addCompte(Compte c,Long idClient, Long idEmploye, Long idBanque) throws ExceptionPerso;
	
	public void deleteCompte (Long idCompte) throws ExceptionPerso;
	
	public Compte updateCompte (Compte c, Long idClient) throws ExceptionPerso;
	
	public Compte getCompteId(Long idCompte) throws ExceptionPerso;
	
	public List<Compte> getCompte ();
	
	public List<Compte> getCompteEmploye (Long idEmploye) throws ExceptionPerso;

}
