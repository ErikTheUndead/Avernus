package com.myapp.gestiondecompte.dao.compte;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;

public class DaoCompteImpl implements IDaoCompte {

	// ATTRIBUTS
	
	private Logger logger = Logger.getLogger("DaoCompteImpl");
	private SessionFactory sf = Singleton.getSf();

	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#addCompte(com.myapp.gestiondecompte.entities.Compte)
	 */
	
	@Override
	public Compte addCompte(Compte c, Long idClient, Long idEmploye, Long idBanque) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Employe e = null;
		Client cl = null;
		Banque b = null;
		cl = ss.get(Client.class, idClient);
		e = ss.get(Employe.class, idEmploye);
		b = ss.get(Banque.class, idBanque);
		c.setBanque(b);
		c.setClient(cl);
		c.setEmploye(e);
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
	public Compte updateCompte(Compte c, Long idClient) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Client cl = ss.get(Client.class, idClient);
		c.setClient(cl);
		ss.update(c); 
		ss.getTransaction().commit();
		ss.close();
		logger.info("le compte "+c.getIdCompte()+" a bien ete modifie");
		return c;
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
		List<Compte> tab = new ArrayList<>();
		Query req = ss.createQuery("from Compte");
		tab = req.list();
		logger.info("<------ liste des comptes recupere : "+tab.size()+" ------>");
		ss.close();
		return tab;
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
		List<Compte> tab = new ArrayList<>();
		Query req = ss.createQuery("from Compte c where c.idEmploye =:l");
		req.setParameter("l","%"+idEmploye+"%");
		tab = req.list();
		ss.close();
		logger.info("<------ Le nombre de compte trouve par idEmploye trouve :"+idEmploye+" est : "+tab.size()+" ------>");
		return tab;
	}

	@Override
	public Compte getCompteId(Long idCompte) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c1 = null;
		c1 = ss.get(Compte.class, idCompte);
//		ss.getTransaction().commit();
		ss.close();
		logger.info("le compte "+c1.getIdCompte()+" a bien ete recuperé");
		return c1;
	}

}
