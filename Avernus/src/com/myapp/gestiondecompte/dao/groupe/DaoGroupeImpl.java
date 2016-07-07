package com.myapp.gestiondecompte.dao.groupe;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.entities.Groupe;

/*
 *  author : BERNARD Thomas
 *   class : DaoGroupeImpl
 *    date : 30/06/2016
 * V 1.0.1
 * log v1.0.1 02/07/2016 : ajout exception , ss.close() manquant ?
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
	public void addEmployeGroupe(Long idG, Long idE) throws ExceptionPerso {
		
		Session session = sf.openSession();

		session.beginTransaction();
		Groupe g = session.get(Groupe.class, idG);
		Employe e = session.get(Employe.class, idE);
		if (g == null || e == null) {
			session.close();
			throw new ExceptionPerso("addEmployeGroupe : les identifiants rentré ne conviennent pas.");
		}
		e.getTabGroupe().add(g);
		g.getTabEmploye().add(e);
		session.update(e);
		session.update(g);
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
	public List<Employe> getEmployesGroupe(Long idG) throws ExceptionPerso {
	
		Session session = sf.openSession();
		session.beginTransaction();
		
		/*String hql ="select tabEmploye FROM Groupe g Where g.idGroupe=:x";
		Query rep = session.createQuery(hql);
		rep.setParameter("x",idG);
		List<Employe> list = new ArrayList<>();
		list = rep.list();*/
		
		
		Groupe g=session.get(Groupe.class, idG);
		if (g == null){
			session.close();
			throw new ExceptionPerso("getEmployesGroupe : il n'y a aucun groupe ayant cet identifiant");
		}
		
		List<Employe> tab= g.getTabEmploye();
		session.getTransaction().commit();
		if (tab.size()==0){
			
			throw new ExceptionPerso("Ce groupe ne possède aucun membre");
		}
		
		/*Query query =session.createQuery("from Employe e inner join e.tabGroupe f where f.idGroupe=:x");
		query.setParameter("x", idG);*/
		
		logger.info("on recupère une liste d'employés "+ tab.size()+ "du groupe d'id : "+idG);
		return tab;
	}
	
	
}
