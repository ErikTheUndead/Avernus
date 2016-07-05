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
public class Retrait extends Operation{

	/*
	 * CONSTRUCTEURS
	 */
	
	public Retrait() {
		super();
		this.setType("Retrait");
	}
	
	public Retrait(Date dateOperation, double montantOperation, Employe employe, Compte compte) {
		super(dateOperation, montantOperation, employe, compte);
		this.setType("Retrait");
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Retrait []";
	}
	
	
	
	

}
