package com.myapp.gestiondecompte.metier.compte;

import java.util.List;

import com.myapp.gestiondecompte.entities.Compte;

public interface IMetierCompte {
	
	public Compte addCompte(Compte c,Long idClient, Long idEmploye, Long idBanque);
	
	public void deleteCompte (Long idCompte);
	
	public Compte updateCompte (Compte c,Long idClient,double solde);
	
	public Compte getCompteId(Long idCompte);
	
	public List<Compte> getCompte ();
	
	public List<Compte> getCompteEmploye (Long idEmploye);

}
