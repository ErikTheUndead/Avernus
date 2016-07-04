package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.entities.CompteCourant;
import com.myapp.gestiondecompte.entities.CompteEpargne;
import com.myapp.gestiondecompte.metier.compte.IMetierCompte;

@SuppressWarnings("unused")
public class TestCompte {

	private static IMetierCompte metier;
	private static ClassPathXmlApplicationContext context;
	Logger logger = Logger.getLogger("TestCompte");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier = (IMetierCompte) context.getBean("metierCompte");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	// @Test
	// public void testSetDao() {
	// metier.
	// }

//	 @Test
//	 public void testAddCompte() throws ParseException, ExceptionPerso {
//	 SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//	 Compte c1 = new CompteCourant(12314, 123, sdf.parse("12.01.1988"),-100);
//	 metier.addCompte(c1, 2L, 1L, 1L);
//	 Compte c2 = new CompteCourant(45678, 2000,
//	 sdf.parse("14.01.2012"),-1000);
//	 metier.addCompte(c2, 2L, 2L, 1L);
//	 Compte c3 = new CompteEpargne(65678, 400, sdf.parse("14.01.2008"),1.89);
//	 metier.addCompte(c3, 3L, 3L, 2L);
//	
//	 // assertNotNull(c1.getIdCompte());
//	 assertNotNull(c2.getIdCompte());
//	 assertNotNull(c2.getClient()); //probleme
//	 assertNotNull(c2.getDateDeCreationCompte());
//	 assertNotNull(c2.getEmploye());
//	 assertNotNull(c2.getNumCompte());
//	 assertNotNull(c2.getSoldeCompte());
//	 }

	// @Test
	// public void testDeleteCompte() {
	// metier.deleteCompte(1L);
	// }

//	 @Test
//	 public void testUpdateCompte() throws ExceptionPerso {
//	 Compte c1 = null;
//	 c1 = metier.getCompteId(6L);
//	 long id1 = (long) c1.getClient().getIdClient();
//	 // Compte c2 = new CompteCourant(123467, 234, new Date(), -200);
//	 metier.updateCompte(c1, 4L,200);
//	 long id2 = (long) metier.getCompteId(6L).getClient().getIdClient();
//	 assertNotEquals(id1 , id2);
//	 }
//
//	 @Test
//	 public void testGetCompte() {
//	 Iterator<Compte> iteCo = metier.getCompte().iterator();
//	 logger.info("<------ la liste des comptes est ------>");
//	 while (iteCo.hasNext()) { logger.info(iteCo.next().toString()); }
//	 }

	@Test
	public void testGetCompteEmploye() throws ExceptionPerso {
		logger.info("<------ la liste des comptes par employe est ------>");
		Iterator<Compte> iteCo = metier.getCompteEmploye(1L).iterator();
		while (iteCo.hasNext()) {
			logger.info(iteCo.next().toString());
		}
	}
}
