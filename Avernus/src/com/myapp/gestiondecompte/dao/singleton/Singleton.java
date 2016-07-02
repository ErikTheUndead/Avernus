package com.myapp.gestiondecompte.dao.singleton;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Singleton {
	
	public static SessionFactory sf = null;
	
	static {
		
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSf() {
		return sf;
	}

	public static void setSf(SessionFactory sf) {
		Singleton.sf = sf;
	}

}
