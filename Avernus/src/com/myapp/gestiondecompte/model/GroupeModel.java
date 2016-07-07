package com.myapp.gestiondecompte.model;

import java.util.ArrayList;
import java.util.List;

import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.entities.Groupe;

public class GroupeModel {

	//Attributs exception
	
		private String exceptionGetGroupe;
		
	
	private String nomGroupe;
	
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	
	private List<Groupe> listGroupe = new ArrayList<>();
	private List<Employe> listEmploye = new ArrayList<>();
	private List<Employe> listEmployeG = new ArrayList<>();
	
	public List<Employe> getListEmployeG() {
		return listEmployeG;
	}
	public void setListEmployeG(List<Employe> listEmployeG) {
		this.listEmployeG = listEmployeG;
	}
	private Long idGroupe;
	private Long idEmploye;

	public Long getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}
	public Long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public List<Groupe> getListGroupe() {
		return listGroupe;
	}
	public void setListGroupe(List<Groupe> listGroupe) {
		this.listGroupe = listGroupe;
	}
	public List<Employe> getListEmploye() {
		return listEmploye;
	}
	public void setListEmploye(List<Employe> listEmploye) {
		this.listEmploye = listEmploye;
	}
	public String getExceptionGetGroupe() {
		return exceptionGetGroupe;
	}
	public void setExceptionGetGroupe(String exceptionGetGroupe) {
		this.exceptionGetGroupe = exceptionGetGroupe;
	}

	
	
}
