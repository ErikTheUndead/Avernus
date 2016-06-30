package com.myapp.gestiondecompte.entities;

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
		// TODO Auto-generated constructor stub
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
