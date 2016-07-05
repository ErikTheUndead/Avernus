package com.myapp.gestiondecompte.model;

import java.util.List;

import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;

public class BanqueModel {
    
	//Attributs exception
	
	private String exceptionGetBanueById;
	private String exceptionGetCompteBanque;
	private String exceptionGetEmployebanque;
	private String exceptionGetClientBanque;
	
	//Attributs tableau
	private List<Banque> tabBanque;
	private List<Compte> tabCompte;
	private List<Banque> banques;
	private List<Employe> tabEmploye;
	private List<Client> tabClient;

	//Attributs simples 
	
	private Long idBanque;
	
	//Get and Set
	
	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	

	public List<Banque> getBanques() {
		return banques;
	}

	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}
	public String getExceptionGetBanueById() {
		return exceptionGetBanueById;
	}

	public void setExceptionGetBanueById(String exceptionGetBanueById) {
		this.exceptionGetBanueById = exceptionGetBanueById;
	}

	public List<Banque> getTabBanque() {
		return tabBanque;
	}

	public void setTabBanque(List<Banque> tabBanque) {
		this.tabBanque = tabBanque;
	}

	public String getExceptionGetCompteBanque() {
		return exceptionGetCompteBanque;
	}

	public void setExceptionGetCompteBanque(String exceptionGetCompteBanque) {
		this.exceptionGetCompteBanque = exceptionGetCompteBanque;
	}

	public String getExceptionGetEmployebanque() {
		return exceptionGetEmployebanque;
	}

	public void setExceptionGetEmployebanque(String exceptionGetEmployebanque) {
		this.exceptionGetEmployebanque = exceptionGetEmployebanque;
	}

	public String getExceptionGetClientBanque() {
		return exceptionGetClientBanque;
	}

	public void setExceptionGetClientBanque(String exceptionGetClientBanque) {
		this.exceptionGetClientBanque = exceptionGetClientBanque;
	}

	public List<Compte> getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(List<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}

	public List<Employe> getTabEmploye() {
		return tabEmploye;
	}

	public void setTabEmploye(List<Employe> tabEmploye) {
		this.tabEmploye = tabEmploye;
	}

	public List<Client> getTabClient() {
		return tabClient;
	}

	public void setTabClient(List<Client> tabClient) {
		this.tabClient = tabClient;
	}
	
	
}
