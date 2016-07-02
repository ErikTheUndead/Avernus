package com.myapp.gestiondecompte.dao.banque;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
 * Author: Julie Brouqu�
 * Date: 30/06/2016
 * V 1.0.1
 * log v1.0.1 02/07/2016 : ajout exception , ss.close() manquant ?
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
	public List<Employe> getEmployeBanque(Long idBanque) throws ExceptionPerso {
		Session ss=sf.openSession();
		ss.beginTransaction();
		List<Employe> tab1=new ArrayList<Employe>();
		Banque b=ss.get(Banque.class, idBanque);
		if (b == null){
			ss.close();
			throw new ExceptionPerso("getEmployeBanque : Il n'y a pas de banque de cette identifiant.");
		}
		List<Compte> tab=b.getTabCompte();
		for(Compte c:tab){
			if(tab1.contains(c.getEmploye())){
				;
			}else{
				tab1.add(c.getEmploye());
			}
			
		}
		ss.getTransaction().commit();
		if (tab.size()==0){	
			ss.close();
			throw new ExceptionPerso("getEmployBanque : Cette Banque ne possède aucun employé");
		}
		ss.close();
		logger.info("La liste de "+tab1.size() +"employ�s a �t� charg�e");
		return tab1;
	}

	@Override
	public List<Client> getClientBanque(Long idBanque) throws ExceptionPerso {
		Session ss=sf.openSession();
		ss.beginTransaction();
		List<Client> tab1=new ArrayList<Client>();
		Banque b=ss.get(Banque.class, idBanque);
		if (b == null)
			throw new ExceptionPerso("getClientBanque : Il n'y a pas de banque de cette identifiant.");
		List<Compte> tab=b.getTabCompte();
		for(Compte c:tab){
			if(tab1.contains(c.getClient())){
				;
			}else{
			tab1.add(c.getClient());
			}
		}
		
		ss.getTransaction().commit();
		ss.close();
		if (tab1.size()==0){	
			throw new ExceptionPerso("getEmployBanque : Cette Banque ne possède aucun employé");
		}
		logger.info("La liste de "+tab1.size()+" clients a été chargée");
		return tab1;
	}

	@Override
	public List<Compte> getCompteBanque(Long idBanque) throws ExceptionPerso {
		Session ss=sf.openSession();
		ss.beginTransaction();
		Query req=ss.createQuery("select tabCompte from Banque b where b.idBanque=:x");
		req.setParameter("x", idBanque);
		ss.getTransaction().commit();
		List<Compte> list=req.list();
		ss.close();
		if (list.size()==0){
			
			throw new ExceptionPerso(" getCompteBanque :Il n'y a pas de banque de ctte identifiant ou elle ne possede aucun compte");
		}
		logger.info("La liste de compte a é té chargée");
		return list;
	}
}
