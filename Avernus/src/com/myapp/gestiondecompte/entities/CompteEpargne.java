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
public class CompteEpargne extends Compte{

	/*Attibut*/
	
	private double tauxInteret;
	/*Constructors*/

	public CompteEpargne() {
		super();
		this.setType("Compte Epargne");
	}

	public CompteEpargne(int numCompte, double soldeCompte,
			Date dateDeCreationCompte) {
		super(numCompte, soldeCompte, dateDeCreationCompte);
		this.setType("Compte Epargne");
	}
	public CompteEpargne(int numCompte, double soldeCompte,
			Date dateDeCreationCompte, double tauxInteret) {
		super(numCompte, soldeCompte, dateDeCreationCompte);
		this.tauxInteret=tauxInteret;
		this.setType("Compte Epargne");
	}
	/*get and set */

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	
	
}
