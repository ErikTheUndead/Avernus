package com.myapp.gestiondecompte.model;

import java.util.List;

import com.myapp.gestiondecompte.entities.Compte;

/*
 * AUTEUR : ERIK DUHEM
 * VERSION : 1.0
 * DATE : 05/07/2016
 */

public class CompteModel {

	/*
	 * ATTRIBUTS
	 */

	private Compte compte;
	private List<Compte> listeComptes;
	private Long idCompte;
	private Long idClient;
	private Long idEmploye;
	private Long idBanque;
	private int num;
	private double solde;
	private String exceptionGetCompteId;
	private String exceptionCreateCompte;
	private String exceptionUpdateCompte;
	private String exceptionDeleteCompte;
	private String exceptionCompteEmploye;

	/*
	 * GETTERS ET SETTERS
	 */

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getExceptionGetCompteId() {
		return exceptionGetCompteId;
	}

	public void setExceptionGetCompteId(String exceptionGetCompteId) {
		this.exceptionGetCompteId = exceptionGetCompteId;
	}

	public String getExceptionCreateCompte() {
		return exceptionCreateCompte;
	}

	public void setExceptionCreateCompte(String exceptionCreateCompte) {
		this.exceptionCreateCompte = exceptionCreateCompte;
	}

	public String getExceptionUpdateCompte() {
		return exceptionUpdateCompte;
	}

	public void setExceptionUpdateCompte(String exceptionUpdateCompte) {
		this.exceptionUpdateCompte = exceptionUpdateCompte;
	}

	public String getExceptionDeleteCompte() {
		return exceptionDeleteCompte;
	}

	public void setExceptionDeleteCompte(String exceptionDeleteCompte) {
		this.exceptionDeleteCompte = exceptionDeleteCompte;
	}

	public String getExceptionCompteEmploye() {
		return exceptionCompteEmploye;
	}

	public void setExceptionCompteEmploye(String exceptionCompteEmploye) {
		this.exceptionCompteEmploye = exceptionCompteEmploye;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	

}
