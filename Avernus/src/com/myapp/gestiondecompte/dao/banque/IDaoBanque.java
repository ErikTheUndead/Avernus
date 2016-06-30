package com.myapp.gestiondecompte.dao.banque;

import java.util.List;

import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;

public interface IDaoBanque {

	public Banque addBanque(Banque b);
	public List<Employe> getEmployeBanque(Long idBanque);
	public List<Client> getClientBanque(Long idBanque);
	public List<Compte> getCompteBanque(Long idBanque);
	
}
