package com.myapp.gestiondecompte.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
/*
 * Author: Julie Brouqué
 * Date: 30/06/2016
 * V 1.0.0
 */
@Entity
public class Groupe {

	//Attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	
	//Association
	
	@ManyToMany
	@JoinTable(name="Groupe_Employe")
	private List<Employe> tabEmploye=new ArrayList<Employe>();
	
	//Constructors
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	
	//Get and Set
	
	public Long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public List<Employe> getTabEmploye() {
		return tabEmploye;
	}
	public void setTabEmploye(List<Employe> tabEmploye) {
		this.tabEmploye = tabEmploye;
	}

}
