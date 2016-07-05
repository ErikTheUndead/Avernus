package com.myapp.gestiondecompte.entities;

import java.util.Date;

import javax.persistence.Entity;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 02/07/2016
 * VERSION : 1.0
 */

@Entity
public class Virement extends Operation{

	/*
	 * CONSTRUCTEURS
	 */
	
	public Virement() {
		super();
		this.setType("Virement");
	}

	public Virement(Date dateOperation, double montantOperation, Employe employe, Compte compte) {
		super(dateOperation, montantOperation, employe, compte);
		this.setType("Virement");
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Virement []";
	}
	
}
