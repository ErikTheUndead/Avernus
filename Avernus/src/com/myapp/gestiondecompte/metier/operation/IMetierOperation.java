package com.myapp.gestiondecompte.metier.operation;

import java.util.Date;
import java.util.List;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Operation;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 30/06/2016
 * VERSION : 1
 * 
 */

public interface IMetierOperation {
	
	public List<Operation> getOperation();
	
	public Operation retrait(Long idCompte, Long idEmploye, double montant,Date dateOperation) throws ExceptionPerso;

	public Operation versement(Long idCompte, Long idEmploye, double montant,Date dateOperation) throws ExceptionPerso;
	
	public List<Operation> virement(Long idCompte1,Long idCompte2, Long idEmploye, double montant,Date dateOperation) throws ExceptionPerso;
	
}
