package com.myapp.gestiondecompte.dao.employe;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Employe;
/*
 * Author: Julie Brouqué
 * Date: 30/06/2016
 * V 1.0.0
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
		Query req=ss.createQuery("select from Employe e");
		ss.getTransaction().commit();
		return req.list();
	}
}
