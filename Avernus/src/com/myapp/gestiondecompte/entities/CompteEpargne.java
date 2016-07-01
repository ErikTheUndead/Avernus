package com.myapp.gestiondecompte.entities;

import java.util.Date;

/*
 *  author : BERNARD Thomas
 *   class : CompteCourant
 *    date : 30/06/2016
 * version : 1.0
 * 
 */

public class CompteEpargne extends Compte{

	/*Attibut*/
	
	private double tauxInteret;
	/*Constructors*/

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(int numCompte, double soldeCompte,
			Date dateDeCreationCompte) {
		super(numCompte, soldeCompte, dateDeCreationCompte);
		// TODO Auto-generated constructor stub
	}
	public CompteEpargne(int numCompte, double soldeCompte,
			Date dateDeCreationCompte, double tauxInteret) {
		super(numCompte, soldeCompte, dateDeCreationCompte);
		this.tauxInteret=tauxInteret;
		// TODO Auto-generated constructor stub
	}
	/*get and set */

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	
	
}
