package com.myapp.gestiondecompte.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * AUTEUR : Erik DUHEM
 * VERSION : 1
 * DATE : 30/06/2016
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeOperation", discriminatorType=DiscriminatorType.STRING)
public class Operation {
	
	/*
	 * ATTRIBUTS 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOperation;
	private Date dateOperation;
	private double montantOperation;
	private String type = "Operation";
	
	/*
	 * ASSOCIATIONS
	 */
	
	@ManyToOne
	@JoinColumn(name="employe")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name="compte")
	private Compte compte;

	/*
	 * GETTERS ET SETTERS 
	 */
	
	public Long getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontantOperation() {
		return montantOperation;
	}

	public void setMontantOperation(double montantOperation) {
		this.montantOperation = montantOperation;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	/*
	 * CONSTRUCTEURS
	 */
	
	public Operation() {
		super();
	}

	public Operation(Date dateOperation, double montantOperation, Employe employe, Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montantOperation = montantOperation;
		this.employe = employe;
		this.compte = compte;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Operation [idOperation=" + idOperation + ", dateOperation=" + dateOperation + ", montantOperation="
				+ montantOperation + ", type=" + type + "]";
	}

}
