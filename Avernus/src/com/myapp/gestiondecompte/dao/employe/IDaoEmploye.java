package com.myapp.gestiondecompte.dao.employe;

import java.util.List;

import com.myapp.gestiondecompte.entities.Employe;

public interface IDaoEmploye {
	
	public Employe addEmploye(Employe e);
	public List<Employe> getEmploye();
	

}
