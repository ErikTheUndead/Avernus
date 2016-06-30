package com.myapp.gestiondecompte.metier.operation;

import java.util.logging.Logger;

import com.myapp.gestiondecompte.entities.Operation;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 30/06/2016
 * VERSION : 1
 * 
 */

public class MetierOperationImpl implements IMetierOperation{

	/*
	 * ATTRIBUTS
	 */
	
	private IMetierOperation daoOperation;
	Logger logger = Logger.getLogger("MetierOperationImpl");
	
	/*
	 * GETTERS ET SETTERS
	 */
	
	public void setDao(IMetierOperation daoOperation) {
		this.daoOperation = daoOperation;
		logger.info("<----------daoOperation injected-------->");
	}
	
	/*
	 * METHODES
	 */
	
	@Override
	public Operation addOperation(Operation op) {
		return daoOperation.addOperation(op);
	}
	

}
