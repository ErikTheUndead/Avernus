package com.myapp.gestiondecompte.model;

import java.util.List;

import com.myapp.gestiondecompte.entities.Operation;

/*
 * AUTEUR : ERIK DUHEM
 * VERSION : 1.0
 * DATE : 05.07.2016
 */

public class OperationModel {

	/*
	 * ATTRIBUTS
	 */

	private String exceptionRetrait;
	private String exceptionVersement;
	private String exceptionVirement;
	private String messageOperation;
	private List<Operation> listeOperations;
	private Operation operation;
	private Long idCompte1;
	private Long idCompte2;
	private Long idEmploye;
	private double montant;

	/*
	 * GETTERS ET SETTERS
	 */

	public String getExceptionRetrait() {
		return exceptionRetrait;
	}

	public void setExceptionRetrait(String exceptionRetrait) {
		this.exceptionRetrait = exceptionRetrait;
	}

	public String getExceptionVersement() {
		return exceptionVersement;
	}

	public void setExceptionVersement(String exceptionVersement) {
		this.exceptionVersement = exceptionVersement;
	}

	public String getExceptionVirement() {
		return exceptionVirement;
	}

	public void setExceptionVirement(String exceptionVirement) {
		this.exceptionVirement = exceptionVirement;
	}

	public List<Operation> getListeOperations() {
		return listeOperations;
	}

	public void setListeOperations(List<Operation> listeOperations) {
		this.listeOperations = listeOperations;
	}

	public Long getIdCompte1() {
		return idCompte1;
	}

	public void setIdCompte1(Long idCompte1) {
		this.idCompte1 = idCompte1;
	}

	public Long getIdCompte2() {
		return idCompte2;
	}

	public void setIdCompte2(Long idCompte2) {
		this.idCompte2 = idCompte2;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public String getMessageOperation() {
		return messageOperation;
	}

	public void setMessageOperation(String messageOperation) {
		this.messageOperation = messageOperation;
	}

}
