package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.gestiondecompte.entities.Compte;
import com.myapp.gestiondecompte.metier.compte.IMetierCompte;

public class TestCompte {

	private static IMetierCompte metier;
	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier = (IMetierCompte) context.getBean("metierCompte");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

//	@Test
//	public void testSetDao() {
//		metier.
//	}

	@Test
	public void testAddCompte() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//		Compte c1 = new Compte(12314, 123, sdf.parse("12.01.1988"));
//		metier.addCompte(c1, 1L, 1L, 1L);
//		Compte c2 = new Compte(45678, 1458, sdf.parse("14.01.2012"));
//		metier.addCompte(c2, 1L, 1L, 1L);
		Compte c2 = new Compte(65678, 458, sdf.parse("14.01.2008"));
		metier.addCompte(c2, 1L, 1L, 1L);
		
//		assertNotNull(c1.getIdCompte());
		assertNotNull(c2.getIdCompte());
		assertNotNull(c2.getClient()); //probleme
		assertNotNull(c2.getDateDeCreationCompte());
		assertNotNull(c2.getEmploye());
		assertNotNull(c2.getNumCompte());
		assertNotNull(c2.getSoldeCompte());
	}

//	@Test
//	public void testDeleteCompte() {
//		metier.deleteCompte(1L);
//	}

//	@Test
//	public void testUpdateCompte() {
//		Compte c = null;
//		c = metier.getCompteId(1L);
//		assert
//	}
//
//	@Test
//	public void testGetCompte() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetCompteEmploye() {
//		fail("Not yet implemented");
//	}

}
