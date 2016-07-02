package com.myapp.gestiondecompte.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
/*
 * Author: Julie Brouqu�
 * Date: 30/06/2016
 * V 1.0.0
 */
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="nomBanque", discriminatorType=DiscriminatorType.STRING)
@Entity
public class Banque {
	
	//Attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBanque;
	private String adresseBanque;
	private int codePostalBanque;
	
	//Association
	
	@OneToMany(mappedBy="banque")
	private List<Compte> tabCompte=new ArrayList<Compte>();
	
	//Constructors

	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Banque(String adresseBanque, int codePostalBanque) {
		super();
		this.adresseBanque = adresseBanque;
		this.codePostalBanque = codePostalBanque;
	}


	//Get and Set
	
	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	

	public String getAdresseBanque() {
		return adresseBanque;
	}

	public void setAdresseBanque(String adresseBanque) {
		this.adresseBanque = adresseBanque;
	}

	public int getCodePostalBanque() {
		return codePostalBanque;
	}

	public void setCodePostalBanque(int codePostalBanque) {
		this.codePostalBanque = codePostalBanque;
	}

	public List<Compte> getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(List<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}
	
}
