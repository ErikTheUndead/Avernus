package com.myapp.gestiondecompte.entities;

import java.util.Date;

import javax.persistence.Entity;

/*
 * AUTEUR : ERIK DUHEM
 * VERSION : 1
 * DATE : 30/06/2016
 * 
 */

@Entity
public class Versement extends Operation{
	
	/*
	 * CONSTRUCTEURS
	 */

	public Versement() {
		super();
		this.setType("Versement");
	}
	
	public Versement(Date dateOperation, double montantOperation, Employe employe, Compte compte) {
		super(dateOperation, montantOperation, employe, compte);
		this.setType("Versement");
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Versement []";
	}
	

}
