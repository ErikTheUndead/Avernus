package com.myapp.gestiondecompte.metier.groupe;

import java.util.List;

import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.entities.Groupe;

public interface IMetierGroupe {

	public Groupe addGroupe(Groupe g);
	public void addEmployeGroupe(Long idG,Long idE);
	public List<Groupe> getGroupe();
	public List<Employe> getEmployesGroupe(Long idG);
}
