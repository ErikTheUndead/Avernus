package com.myapp.gestiondecompte.metier.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.operation.IDaoOperation;
import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;
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
	
	private IDaoOperation daoOperation;
	Logger logger = Logger.getLogger("MetierOperationImpl");
	private SessionFactory sf = Singleton.getSf();
	
	/*
	 * GETTERS ET SETTERS
	 */
	
	public void setDao(IDaoOperation daoOperation) {
		this.daoOperation = daoOperation;
		logger.info("<----------daoOperation injected-------->");
	}

	/*
	 * METHODES
	 */
	
//	@Override
//	public Operation addOperation(Operation op) {
//		return daoOperation.addOperation(op);
//	}
	
	@Override
	public Operation retrait(Long idCompte, Long idEmploye, double montant,Date dateOperation) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = null;
		Employe e = null;
		Operation op = null;
		c = ss.get(Compte.class, idCompte);
		e = ss.get(Employe.class, idEmploye);
		op = new Operation(dateOperation, -montant, e, c);
//		ss.save(op);
//		ss.getTransaction().commit();
		ss.close();
		daoOperation.addOperation(op);
		return op;
	}

	@Override
	public Operation versement(Long idCompte, Long idEmploye, double montant,Date dateOperation) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = null;
		Employe e = null;
		Operation op = null;
		c = ss.get(Compte.class, idCompte);
		e = ss.get(Employe.class, idEmploye);
		op = new Operation(dateOperation, montant, e, c);
//		ss.save(op);
//		ss.getTransaction().commit();
		ss.close();
		daoOperation.addOperation(op);
		return op;
	}

	@Override
	public List<Operation> virement(Long idCompte1, Long idCompte2, Long idEmploye,
			double montant,Date dateOperation) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		List<Operation> tabOp = new ArrayList<>();
		Compte c1 = null;
		Compte c2 = null;
		Employe e = null;
		Operation op1 = null;
		Operation op2 = null;
		c1 = ss.get(Compte.class, idCompte1);
		c2 = ss.get(Compte.class, idCompte2);
		e = ss.get(Employe.class, idEmploye);
		op1 = new Operation(dateOperation, -montant, e, c1);
		op2 = new Operation(dateOperation, montant, e, c2);
		tabOp.add(op1);
		tabOp.add(op2);
//		ss.save(op1);
//		ss.save(op2);
//		ss.getTransaction().commit();
		ss.close();
		daoOperation.addOperation(op1);
		daoOperation.addOperation(op2);
		return tabOp;
	}
	

}
