package com.myapp.gestiondecompte.dao.banque;

import java.util.List;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;
/*
 * Author: Julie Brouqu�
 * Date: 30/06/2016
 * V 1.0.0
 */
public interface IDaoBanque {

	
	public Banque addBanque(Banque b);
	public List<Employe> getEmployeBanque(Long idBanque) throws ExceptionPerso;
	public List<Client> getClientBanque(Long idBanque) throws ExceptionPerso;
	public List<Compte> getCompteBanque(Long idBanque) throws ExceptionPerso;
	
}
