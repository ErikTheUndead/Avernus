package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.gestiondecompte.entities.Banque;
import com.myapp.gestiondecompte.entities.Bnp;
import com.myapp.gestiondecompte.entities.Cic;
import com.myapp.gestiondecompte.entities.Lcl;
import com.myapp.gestiondecompte.metier.banque.IMetierBanque;

public class TestBanque {

	private static IMetierBanque metier;
	private static ClassPathXmlApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier =  (IMetierBanque) context.getBean("metierBanque");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testAddBanque() {
		Banque b1= new Bnp("2 rue des moines", 75013);
		metier.addBanque(b1);
		Banque b2= new Cic("17 rue de la cloche", 75002);
		metier.addBanque(b2);
		Banque b3= new Lcl("95 rue Napoleon Bonaparte", 75016);
		metier.addBanque(b3);
		assertNotNull(b1.getIdBanque());
	}

	@Test
	public void testGetEmployeBanque() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClientBanque() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCompteBanque() {
		fail("Not yet implemented");
	}

}
