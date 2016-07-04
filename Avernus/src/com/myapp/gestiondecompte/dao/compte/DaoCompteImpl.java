package com.myapp.gestiondecompte.dao.compte;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;
/*
 * AUTEUR : Erik DUHEM
 * DATE : 30/06/2016
 * version : 1.0.1
 * log v1.0.1 02/07/2016 : ajout exception
 */
public class DaoCompteImpl implements IDaoCompte {

	// ATTRIBUTS
	
	private Logger logger = Logger.getLogger("DaoCompteImpl");
	private SessionFactory sf = Singleton.getSf();

	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#addCompte(com.myapp.gestiondecompte.entities.Compte)
	 */
	
	@Override
	public Compte addCompte(Compte c, Long idClient, Long idEmploye, Long idBanque) throws ExceptionPerso {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Employe e = null;
		Client cl = null;
		Banque b = null;
		cl = ss.get(Client.class, idClient);
		e = ss.get(Employe.class, idEmploye);
		b = ss.get(Banque.class, idBanque);
		if (cl==null || e==null || b == null){
			ss.close();
			throw new ExceptionPerso("addCompte : un ou plusieur identifiant n'est pas valide");
		}
		c.setBanque(b);
		c.setClient(cl);
		c.setEmploye(e);
		ss.save(c);
		ss.getTransaction().commit();
		ss.close();
		logger.info("le compte "+c.getIdCompte()+" á bien été enregistré : "
				+c.getClient().getIdClient() + "");
		return c;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#deleteCompte(java.lang.Long)
	 */

	@Override
	public void deleteCompte(Long idCompte) throws ExceptionPerso {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = null;
		c = ss.get(Compte.class, idCompte);
		if(c == null){
			ss.close();
			throw new ExceptionPerso("deleteClient : il n'y a aucun client de cette identifiant");
		}
		ss.delete(c); 
		ss.getTransaction().commit();
		ss.close();
		logger.info("le compte "+c.getIdCompte()+" a bien été supprimé");
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#updateCompte(com.myapp.gestiondecompte.entities.Compte)
	 */

	@Override
	public Compte updateCompte(Compte c, Long idClient) throws ExceptionPerso {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Client cl = ss.get(Client.class, idClient);
		if(cl == null){
			ss.close();
			throw new ExceptionPerso("updateClient : il n'y a aucun client de cette identifiant");
		}
		c.setClient(cl);
		ss.update(c); 
		ss.getTransaction().commit();
		ss.close();
		logger.info("le compte "+c.getIdCompte()+" a bien ete modifié");
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
	public List<Compte> getCompteEmploye(Long idEmploye) throws ExceptionPerso {
		Session ss = sf.openSession();
		ss.beginTransaction();
		List<Compte> tab = new ArrayList<>();
		String hql = "from Compte c where idEmploye =:l";
//		String hql = "FROM Compte c INNER JOIN c.employe e WHERE e.idEmploye =:l";
		Query req = ss.createQuery(hql);
		req.setParameter("l",idEmploye);
		tab = req.list();
		ss.close();
		if (tab.size()==0) {
			throw new ExceptionPerso("il n'y a pas d'employe de cette identifiant : "+idEmploye);
		}
		logger.info("<------ Le nombre de compte trouve par idEmploye trouve :"+idEmploye+" est : "+tab.size()+" ------>");
		return tab;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.myapp.gestiondecompte.dao.compte.IDaoCompte#getCompteId(java.lang.Long)
	 */

	@Override
	public Compte getCompteId(Long idCompte) throws ExceptionPerso {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c1 = null;
		c1 = ss.get(Compte.class, idCompte);
	
		ss.close();
		if(c1 == null)
			throw new ExceptionPerso("getCompteId : il n'y a aucun compte de cette identifiant");
		
		logger.info("le compte "+c1.getIdCompte()+" a bien ete recuperé");
		return c1;
	}

}
