package com.myapp.gestiondecompte.dao.compte;

import java.util.List;

import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Compte;

public class DaoCompteImpl implements IDaoCompte {

	// ATTRIBUTS
	
	private Logger logger = Logger.getLogger("DaoCompteImpl");
	private SessionFactory sf = Singleton.getSf();

	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#addCompte(com.myapp.gestiondecompte.entities.Compte)
	 */
	
	@Override
	public Compte addCompte(Compte c) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(c);
		ss.getTransaction().commit();
		ss.close();
		logger.info("le compte "+c.getIdCompte()+" á bien été enregistré");
		return c;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#deleteCompte(java.lang.Long)
	 */

	@Override
	public void deleteCompte(Long idCompte) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = null;
		c = ss.get(Compte.class, idCompte);
		ss.delete(c); 
		ss.getTransaction().commit();
		ss.close();
		logger.info("le compte "+c.getIdCompte()+" a bien ete supprime");
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#updateCompte(com.myapp.gestiondecompte.entities.Compte)
	 */

	@Override
	public Compte updateCompte(Compte c) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c1 = null;
		c1 = ss.get(Compte.class, c.getIdCompte());
		ss.update(c1); 
		ss.getTransaction().commit();
		ss.close();
		logger.info("le compte "+c.getIdCompte()+" a bien ete modifie");
		return c1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#getCompte()
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getCompte() {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Query req = ss.createQuery("from Compte");
		logger.info("<------ liste des comptes recupere : "+req.list().size()+" ------>");
		ss.close();
		return req.list();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#getCompteEmploye(java.lang.Long)
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getCompteEmploye(Long idEmploye) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Query req = ss.createQuery("from Compte c where c.idEmploye =:l");
		req.setParameter("l","%"+idEmploye+"%");
		ss.close();
		logger.info("<------ Le nombre de compte trouve par idEmploye trouve :"+idEmploye+" est : "+req.list().size()+" ------>");
		return req.list();
	}

}
