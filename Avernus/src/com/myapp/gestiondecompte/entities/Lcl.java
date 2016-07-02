package com.myapp.gestiondecompte.entities;

import javax.persistence.Entity;

@Entity
public class Lcl extends Banque{

	public Lcl() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	public Lcl(String adresseBanque, int codePostalBanque) {
		super(adresseBanque, codePostalBanque);
		// TODO Auto-generated constructor stub
	}
	
	
}
