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
		// TODO Auto-generated constructor stub
	}

	public Virement(Date dateOperation, double montantOperation, Employe employe, Compte compte) {
		super(dateOperation, montantOperation, employe, compte);
		// TODO Auto-generated constructor stub
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
