package com.myapp.gestiondecompte.dao.banque;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.gestiondecompte.dao.singleton.Singleton;
import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.Employe;
/*
 * Author: Julie Brouqu�
 * Date: 30/06/2016
 * V 1.0.0
 */

public class DaoBanqueImpl implements IDaoBanque{
	
	//Attributs
	
	SessionFactory sf=Singleton.getSf();
	Logger logger=Logger.getLogger("DaoBanqueImpl");  
		
	
	//M�thodes
	
	@Override
	public Banque addBanque(Banque b) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		ss.save(b);
		ss.getTransaction().commit();
		logger.info("La banque "+b.getIdBanque()+ " a bien �t� ajout�e");
		ss.close();
		return b;
	}

	@Override
	public List<Employe> getEmployeBanque(Long idBanque) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		List<Employe> tab1=new ArrayList<Employe>();
		Banque b=ss.get(Banque.class, idBanque);
		List<Compte> tab=b.getTabCompte();
		for(Compte c:tab){
			if(tab1.contains(c.getEmploye())){
				;
			}else{
				tab1.add(c.getEmploye());
			}
			
		}
		ss.getTransaction().commit();
		logger.info("La liste de "+tab1.size() +"employ�s a �t� charg�e");
		return tab1;
	}

	@Override
	public List<Client> getClientBanque(Long idBanque) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		List<Client> tab1=new ArrayList<Client>();
		Banque b=ss.get(Banque.class, idBanque);
		List<Compte> tab=b.getTabCompte();
		for(Compte c:tab){
			if(tab1.contains(c.getClient())){
				;
			}else{
			tab1.add(c.getClient());
			}
		}
		ss.getTransaction().commit();
		logger.info("La liste de "+tab1.size()+" clients a �t� charg�e");
		return tab1;
	}

	@Override
	public List<Compte> getCompteBanque(Long idBanque) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		Query req=ss.createQuery("select tabCompte from Banque b where b.idBanque=:x");
		req.setParameter("x", idBanque);
		ss.getTransaction().commit();
		logger.info("La liste de compte a �t� charg�e");
		return req.list();
	}
}
