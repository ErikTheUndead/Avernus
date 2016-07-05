package com.myapp.gestiondecompte.dao.operation;

import java.util.List;

import com.myapp.gestiondecompte.entities.Operation;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 30/06/2016
 * VERSION : 1
 * 
 */

public interface IDaoOperation {
	
	public List<Operation> getOperation();
	
	public Operation addOperation(Operation op);
	
}
