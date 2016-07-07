package com.myapp.gestiondecompte.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
 * Author: Julie Brouqu�
 * Date: 30/06/2016
 * V 1.0.0
 */
@Entity
public class Client {

	//Attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String prenomClient;
	
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	private String adresseClient;
	
	//Association
	
	@OneToMany(mappedBy="client",  cascade=CascadeType.ALL) 
	private List<Compte> tabCompte=new ArrayList<Compte>();
	
	//Constructors
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nomClient, String prenomClient, Date dateDeNaissance,
			String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateDeNaissance = dateDeNaissance;
		this.adresseClient = adresseClient;
	}
	
	//Get and Set

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public List<Compte> getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(List<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}

	
}
