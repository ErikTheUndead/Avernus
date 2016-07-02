package com.myapp.gestiondecompte.dao.employe;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Employe;
/*
 * Author: Julie Brouqu�
 * Date: 30/06/2016
 * V 1.0.1
 * log v1.0.1 02/07/2016:ajout session close ?
 */
public class DaoEmployeImpl implements IDaoEmploye{

	//Attributs
	
	SessionFactory sf=Singleton.getSf();
	Logger logger=Logger.getLogger("DaoEmployeImpl");  
	
	//Methodes
	
	@Override
	public Employe addEmploye(Employe e) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		ss.save(e);
		ss.getTransaction().commit();
		logger.info("L'employé "+e.getNomEmploye()+ " a bien été ajouté");
		ss.close();
		return e;
	}

	@Override
	public List<Employe> getEmploye() {
		Session ss=sf.openSession();
		ss.beginTransaction();
		Query req=ss.createQuery("from Employe e");
		ss.getTransaction().commit();
		logger.info("ils existe"+req.list().size()+" employés");
		List<Employe> list = req.list();
		ss.close();
		return list;
	}
}
