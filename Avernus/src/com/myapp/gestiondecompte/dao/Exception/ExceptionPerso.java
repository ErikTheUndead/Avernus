package com.myapp.gestiondecompte.dao.Exception;

import java.util.Date;
import java.util.logging.Logger;

public class ExceptionPerso extends Exception{

	
	Logger logger = Logger.getLogger("ExceptionPerso");

	public ExceptionPerso(String msg) {
		super(msg);
		
		logger.warning("Error "+ new Date() +" : " + msg);
	}
	
	
	
}
