package com.myapp.gestiondecompte.dao.groupe;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.entities.Groupe;

/*
 *  author : BERNARD Thomas
 *   class : DaoGroupeImpl
 *    date : 30/06/2016
 * version : 1.0
 * 
 */

public class DaoGroupeImpl implements IDaoGroupe {

	
	Logger logger = Logger.getLogger("DaoGroupeImpl") ;
	private SessionFactory sf = Singleton.getSf();
	
	
	@Override
	public Groupe addGroupe(Groupe g) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(g);
		session.getTransaction().commit();
		session.close();
		logger.info("le groupe "+g.getNomGroupe()+ "  avec l'id "+g.getIdGroupe()+" a bien été enregistré");
		
		return g;
	}
	
	@Override
	public void addEmployeGroupe(Long idG, Long idE) {
		
		Session session = sf.openSession();

		session.beginTransaction();
		Groupe g = session.get(Groupe.class, idG);
		Employe e = session.get(Employe.class, idE);
		e.getTabGroupe().add(g);
		session.update(e);
		logger.info("On ajoute l'employé d'id : "+e.getIdEmploye() + " au groupe d'id : " + g.getIdGroupe());

		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public List<Groupe> getGroupe() {
		
		
		logger.info("on recupère la liste des groupes");
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql ="FROM Groupe ";
		Query rep = session.createQuery(hql);
		List<Groupe> list = new ArrayList<>();
		list = rep.list();
		session.getTransaction().commit();
		session.close();
		
		return list;
		
	}
	
	@Override
	public List<Employe> getEmployesGroupe(Long idG) {
	
		
		logger.info("on recupère une liste d'employe du groupe d'id : "+idG);
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql ="FROM Employe Where idGroupe = ?";
		Query rep = session.createQuery(hql);
		rep.setLong(0, idG);
		List<Employe> list = new ArrayList<>();
		list = rep.list();
		session.getTransaction().commit();
		session.close();
		
		return list;
	}
	
	
}
