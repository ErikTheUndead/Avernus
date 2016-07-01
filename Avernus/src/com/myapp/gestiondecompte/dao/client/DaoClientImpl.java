package com.myapp.gestiondecompte.dao.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Client;

/*
 *  author : BERNARD Thomas
 *   class : DaoClientImpl
 *    date : 30/06/2016
 * version : 1.0
 * 
 */

public class DaoClientImpl implements IDaoClient {
	
	//Attribut
	Logger logger = Logger.getLogger("DaoClientImpl") ;
	private SessionFactory sf = Singleton.getSf();
	
	//Methode
	@Override
	public Client addClient(Client c) {
	
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
		session.close();
		logger.info("le client "+c.getNomClient()+ "  avec l'id "+c.getIdClient()+" a bien été enregistré ");
		return c;
	}

	@Override
	public void deleteClient(Long idC) {
		
		Session session = sf.openSession();

		session.beginTransaction();
		Client c = session.get(Client.class, idC);
		session.delete(c);
		logger.info("on supprime le client d'id : " + c.getIdClient());

		session.getTransaction().commit();
		session.close();
	}
		
	

	@Override
	public Client updateClient(Client c) {
		
		logger.info("on modifie l'étudiant  d'id : "+ c.getIdClient());
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(c);
		session.getTransaction().commit();
		session.close();
		return c;
	}

	@Override
	public List<Client> getClients() {
		
		logger.info("on recupère la liste des clients");
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql ="FROM Client ";
		Query rep = session.createQuery(hql);
		List<Client> list = new ArrayList<>();
		list = rep.list();
		session.getTransaction().commit();
		session.close();
		
		return list;
		
		
	}

	@Override
	public List<Client> getClientsByMc(String mc) {
		logger.info("on recupère une liste de clients par mot clé");
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql ="FROM Client Where nomClient  LIKE ? OR prenomClient LIKE ?";
		Query rep = session.createQuery(hql);
		rep.setString(0, "%"+mc+"%");
		rep.setString(1, "%"+mc+"%");
		List<Client> list = new ArrayList<>();
		list = rep.list();
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public Client getClientById(Long id) {
		
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql ="FROM Client WHERE idClient = ?";
		Query rep = session.createQuery(hql);
		rep.setLong(0, id);
		
		Client c =(Client) rep.list().get(0);
		session.getTransaction().commit();
		session.close();
		logger.info("on recupere le client d'id : "+id);
		return c;	
		
	}

}
