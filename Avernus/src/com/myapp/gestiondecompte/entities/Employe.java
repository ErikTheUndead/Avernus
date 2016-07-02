package com.myapp.gestiondecompte.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/*
 *  author : BERNARD Thomas
 *   class : Employe
 *    date : 30/06/2016
 * version : 1.0
 * 
 */
@Entity
public class Employe {
	
	/*------------Attribut-----------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmploye;
	private String nomEmploye;
	private String codeEmploye;

	/*------------Association---------*/
	@ManyToMany(mappedBy = "tabEmploye")
	List<Groupe> tabGroupe = new ArrayList<>();
	
	
	/*------------get and set---------*/

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getCodeEmploye() {
		return codeEmploye;
	}

	public void setCodeEmploye(String codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

	public List<Groupe> getTabGroupe() {
		return tabGroupe;
	}

	public void setTabGroupe(List<Groupe> tabGroupe) {
		this.tabGroupe = tabGroupe;
	}
	/*------------Constructor---------*/

	public Employe(String nomEmploye, String codeEmploye) {
		super();
		this.nomEmploye = nomEmploye;
		this.codeEmploye = codeEmploye;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
