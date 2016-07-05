package com.myapp.gestiondecompte.model;

import java.util.List;

import com.myapp.gestiondecompte.entities.Banque;

public class BanqueModel {
    
	private String exceptionGetBanueById;
	

	private Long idBanque;
	
	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	private List<Banque> banques;

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
}
