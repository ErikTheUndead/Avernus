package com.myapp.gestiondecompte.metier.groupe;

import java.util.List;

import com.myapp.gestiondecompte.dao.groupe.IDaoGroupe;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.entities.Groupe;

public class MetierGroupeImpl implements IMetierGroupe{

	/*injection*/
	private IDaoGroupe idao;

	/*Methode*/
	@Override
	public Groupe addGroupe(Groupe g) {
		// TODO Auto-generated method stub
		return idao.addGroupe(g);
	}

	@Override
	public void addEmployeGroupe(Long idG, Long idE) {
		// TODO Auto-generated method stub
		idao.addEmployeGroupe(idG, idE);
	}

	@Override
	public List<Groupe> getGroupe() {
		// TODO Auto-generated method stub
		return idao.getGroupe();
	}

	@Override
	public List<Employe> getEmployesGroupe(Long idG) {
		// TODO Auto-generated method stub
		return idao.getEmployesGroupe(idG);
	}
}
