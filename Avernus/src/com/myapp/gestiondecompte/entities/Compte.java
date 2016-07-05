package com.myapp.gestiondecompte.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 *  author : BERNARD Thomas
 *   class : Compte
 *    date : 30/06/2016
 * version : 1.0
 * 
 */

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCompte", discriminatorType=DiscriminatorType.STRING)
@Entity
public class Compte {
	
	/*~~~~~~~Attribut~~~~~~~~~~~*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompte;
	private int numCompte;
	private double soldeCompte;
	private Date dateDeCreationCompte;

	/*~~~~~~~~~~~Association~~~~~~~~~~~*/
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	@OneToMany(mappedBy="compte",fetch = FetchType.EAGER)
	private List<Operation> listOperation = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "idEmploye")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name ="idBanque")
	private Banque banque;
	
	/*~~~~~~~Get and Set~~~~~~~~~~~*/
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public double getSoldeCompte() {
		return soldeCompte;
	}
	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	public Date getDateDeCreationCompte() {
		return dateDeCreationCompte;
	}
	public void setDateDeCreationCompte(Date dateDeCreationCompte) {
		this.dateDeCreationCompte = dateDeCreationCompte;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Operation> getListOperation() {
		return listOperation;
	}
	public void setListOperation(List<Operation> listOperation) {
		this.listOperation = listOperation;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/*~~~~~~~Constructor~~~~~~~~~~~*/
	
	public Compte(int numCompte, double soldeCompte, Date dateDeCreationCompte) {
		super();
		this.numCompte = numCompte;
		this.soldeCompte = soldeCompte;
		this.dateDeCreationCompte = dateDeCreationCompte;
	}
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", numCompte=" + numCompte
				+ ", soldeCompte=" + soldeCompte + ", dateDeCreationCompte="
				+ dateDeCreationCompte + "]";
	}
	
}
