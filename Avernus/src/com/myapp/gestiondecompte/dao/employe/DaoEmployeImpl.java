package com.myapp.gestiondecompte.dao.employe;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Banque;
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
		List<Employe> tab = req.list();
		ss.getTransaction().commit();
		logger.info("ils existe"+ tab.size()+" employés");
		ss.close();
		return tab;
	}

	@Override
	public void deleteEmploye(Long idEmploye) throws ExceptionPerso {
		Session session = sf.openSession();

		session.beginTransaction();
		Employe e = session.get(Employe.class, idEmploye);
		if (e==null){
			session.close();
			throw new ExceptionPerso("deleteEmploye : il n'y a aucun employe de cet identifiant");
		}
		session.delete(e);
		logger.info("on supprime l'employet d'id : " + e.getIdEmploye());

		session.getTransaction().commit();
		session.close();
	
		
	}

	@Override
	public Employe getEmployeParId(Long idEmploye) throws ExceptionPerso {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Employe e=session.get(Employe.class, idEmploye);

		session.getTransaction().commit();
		session.close();
		if (e == null)
			throw new ExceptionPerso("Il n'y a aucun employé attribué à cet identifiant");
		logger.info("on recupere l'employé d'id : "+idEmploye);
		return e;	
		
	}
}
