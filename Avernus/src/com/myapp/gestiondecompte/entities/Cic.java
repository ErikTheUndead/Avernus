package com.myapp.gestiondecompte.entities;

import javax.persistence.Entity;

@Entity
public class Cic extends Banque{

	public Cic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cic(String adresseBanque, int codePostalBanque) {
		super(adresseBanque, codePostalBanque);
		// TODO Auto-generated constructor stub
	}
	
	
}
