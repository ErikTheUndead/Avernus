package com.myapp.gestiondecompte.model;

import java.util.List;

import com.myapp.gestiondecompte.entities.Employe;

public class EmployeModel {

	//Attributs simples
	
	private String nomEmploye;
	private String codeEmploye;
	private Employe employe;
	
	//Attributs tableaux
	
	private List<Employe> tabEmploye;
	
	//Get and Set
	
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
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public List<Employe> getTabEmploye() {
		return tabEmploye;
	}
	public void setTabEmploye(List<Employe> tabEmploye) {
		this.tabEmploye = tabEmploye;
	}
}
