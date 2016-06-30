package com.myapp.gestiondecompte.dao.compte;

import java.util.List;

import com.myapp.gestiondecompte.entities.Compte;

public interface IDaoCompte {
	
	public Compte addCompte(Compte c);
	
	public void deleteCompte (Long idCompte);
	
	public Compte updateCompte (Compte c);
	
	public List<Compte> getCompte ();
	
	public List<Compte> getCompteEmploye (Long idEmploye);

}
