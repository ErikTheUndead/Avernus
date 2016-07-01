package com.myapp.gestiondecompte.entities;

import java.util.Date;

import javax.persistence.Entity;

/*
 *  author : BERNARD Thomas
 *   class : CompteCourant
 *    date : 30/06/2016
 * version : 1.0
 * 
 */
@Entity
public class CompteCourant extends Compte{

	/*Attribut*/
	private double decouvert;

	/*Contructors*/
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(int numCompte, double soldeCompte,
			Date dateDeCreationCompte) {
		super(numCompte, soldeCompte, dateDeCreationCompte);
		// TODO Auto-generated constructor stub
	}
	public CompteCourant(int numCompte, double soldeCompte,
			Date dateDeCreationCompte , double decouvert) {
		super(numCompte, soldeCompte, dateDeCreationCompte);
		this.decouvert=decouvert;
		// TODO Auto-generated constructor stub
	}
	/*Get and Set*/

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}


	
	
}
