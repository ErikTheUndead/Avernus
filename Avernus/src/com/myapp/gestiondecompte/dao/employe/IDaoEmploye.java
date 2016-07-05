package com.myapp.gestiondecompte.dao.employe;

import java.util.List;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Employe;
/*
 * Author: Julie Brouqu�
 * Date: 30/06/2016
 * V 1.0.0
 */
public interface IDaoEmploye {
	
	public Employe addEmploye(Employe e);
	public List<Employe> getEmploye();
	public void deleteEmploye(Long idEmploye) throws ExceptionPerso;
	public Employe getEmployeParId(Long idEmploye) throws ExceptionPerso;
	

}
