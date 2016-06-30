package com.myapp.gestiondecompte.dao.banque;

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

public class DaoBanqueImpl implements IDaoBanque{
	
	SessionFactory sf=Singleton.getSf();
	Logger logger=Logger.getLogger("DaoBanqueImpl");  
			
	@Override
	public Banque addBanque(Banque b) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		ss.save(b);
		ss.getTransaction().commit();
		logger.info("La banque "+b.getNomBanque()+ " a bien été ajoutée");
		ss.close();
		return b;
	}

	@Override
	public List<Employe> getEmployeBanque(Long idBanque) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		Query req=ss.createQuery("select from Employe e, Compte s, Banque b where (b.idbanque=s.idBanque and e.idEmploye=s.idEmploye and b.idBanque=:x)");
		req.setParameter("x", idBanque);
		ss.getTransaction().commit();
		return req.list();
	}

	@Override
	public List<Client> getClientBanque(Long idBanque) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		Query req=ss.createQuery("select from Client c, Compte s, Banque b where (b.idbanque=s.idBanque and c.idClient=s.idClient and b.idBanque=:x)");
		req.setParameter("x", idBanque);
		ss.getTransaction().commit();
		return req.list();
	}

	@Override
	public List<Compte> getCompteBanque(Long idBanque) {
		Session ss=sf.openSession();
		ss.beginTransaction();
		Query req=ss.createQuery("select tabCompte from Banque b where b.idBanque=:x");
		req.setParameter("x", idBanque);
		ss.getTransaction().commit();
		return req.list();
	}
}
