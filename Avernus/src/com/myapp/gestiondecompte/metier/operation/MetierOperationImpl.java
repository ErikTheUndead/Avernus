package com.myapp.gestiondecompte.metier.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.dao.operation.IDaoOperation;
import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.entities.Operation;
import com.myapp.gestiondecompte.entities.Retrait;
import com.myapp.gestiondecompte.entities.Versement;
import com.myapp.gestiondecompte.entities.Virement;

/*
 * AUTEUR : ERIK DUHEM
 * DATE : 30/06/2016
 * VERSION : 1.1
 * log v1.0.1 02/07/2016 : ajout exception 
 */

@SuppressWarnings("unused")
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
	
	public void setDaoOperation(IDaoOperation daoOperation) {
		this.daoOperation = daoOperation;
		logger.info("<------ daoOperation injected ------>");
	}

	/*
	 * METHODES
	 */
	
	@Override
	public Operation retrait(Long idCompte, Long idEmploye, double montant,Date dateOperation) throws ExceptionPerso {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = null;
		Employe e = null;
		Operation op = null;
		double solde = 0;
		c = ss.get(Compte.class, idCompte);
		e = ss.get(Employe.class, idEmploye);
		op = new Retrait(dateOperation, montant, e, c);
		if (c == null || e == null){
			ss.close();
			throw new ExceptionPerso("retrait : Les identifiants rentré ne sonnt pas correctes");
		}
		op = new Operation(dateOperation, -montant, e, c);
		solde = c.getSoldeCompte();
		c.setSoldeCompte(solde-montant);
		ss.saveOrUpdate(c);
		ss.close();
		logger.info("<------ Le retrait a bien été effectué ------>");
		daoOperation.addOperation(op);
		return op;
	}

	@Override
	public Operation versement(Long idCompte, Long idEmploye, double montant,Date dateOperation) throws ExceptionPerso {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = null;
		Employe e = null;
		Operation op = null;
		double solde = 0;
		c = ss.get(Compte.class, idCompte);
		e = ss.get(Employe.class, idEmploye);
		op = new Versement(dateOperation, montant, e, c);
		if (c == null || e == null){
			ss.close();
			throw new ExceptionPerso("retrait : Les identifiants rentré ne sonnt pas correctes");
		}
		op = new Operation(dateOperation, montant, e, c);
		solde = c.getSoldeCompte();
		c.setSoldeCompte(solde+montant);
		ss.saveOrUpdate(c);
		ss.getTransaction().commit();
		ss.close();
		logger.info("<------ Le versement a bien été effectué ------>");
		daoOperation.addOperation(op);
		return op;
	}

	@Override
	public List<Operation> virement(Long idCompte1, Long idCompte2, Long idEmploye,
			double montant,Date dateOperation) {
//		retrait(idCompte1, idEmploye, montant, dateOperation);
//		versement(idCompte2, idEmploye, montant, dateOperation);
		Session ss = sf.openSession();
		ss.beginTransaction();
		List<Operation> tabOp = new ArrayList<>();
		Compte c1 = null,c2 = null;
		Employe e = null;
		Operation op1 = null, op2 = null;
		double solde1 = 0,solde2 = 0;
		c1 = ss.get(Compte.class, idCompte1);
		c2 = ss.get(Compte.class, idCompte2);
		e = ss.get(Employe.class, idEmploye);
		op1 = new Virement(dateOperation, -montant, e, c1);
		op2 = new Virement(dateOperation, montant, e, c2);
		solde1 = c1.getSoldeCompte();
		solde2 = c2.getSoldeCompte();
		c1.setSoldeCompte(solde1-montant);
		c2.setSoldeCompte(solde2+montant);
		tabOp.add(op1);
		tabOp.add(op2);
		ss.saveOrUpdate(c1);
		ss.saveOrUpdate(c2);
		ss.getTransaction().commit();
		ss.close();
		daoOperation.addOperation(op1);
		daoOperation.addOperation(op2);
		logger.info("<------ Le virement entre le compte "+idCompte1+" et "+idCompte2+" a bien été effectué ------>");
		return tabOp;
	}
	

}
