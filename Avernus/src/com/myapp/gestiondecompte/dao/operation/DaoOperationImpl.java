package com.myapp.gestiondecompte.dao.operation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Operation;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 30/06/2016
 * VERSION : 1
 * 
 */

public class DaoOperationImpl implements IDaoOperation{
	
	/*
	 * ATTRIBUTS
	 */
	
	private Logger logger = Logger.getLogger("DaoOperationImpl");
	private SessionFactory sf = Singleton.getSf();

	/*
	 * METHODES
	 */
	
	@Override
	public Operation addOperation(Operation op) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(op);
		ss.getTransaction().commit();
		ss.close();
		logger.info("l'operation "+op.getIdOperation()+" a bien été enregistré");
		return op;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> getOperation() {
		Session ss = sf.openSession();
		ss.beginTransaction();
		List<Operation> tab = new ArrayList<>();
		Query req = ss.createQuery("from Operation");
		tab = req.list();
		ss.close();
		logger.info("<------ liste des opérations recuperée : "+tab.size()+" ------>");
		return tab;
	}

	
	
}
