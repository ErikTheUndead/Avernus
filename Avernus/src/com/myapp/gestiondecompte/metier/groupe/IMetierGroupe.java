package com.myapp.gestiondecompte.metier.groupe;

import java.util.List;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.entities.Groupe;

/*
 *  author : BERNARD Thomas
 *   interface : IMetierGroupe
 *    date : 30/06/2016
 * version : 1.0
 * 
 */
public interface IMetierGroupe {

	public Groupe addGroupe(Groupe g);
	public void addEmployeGroupe(Long idG,Long idE) throws ExceptionPerso;
	public List<Groupe> getGroupe();
	public List<Employe> getEmployesGroupe(Long idG) throws ExceptionPerso;
}
