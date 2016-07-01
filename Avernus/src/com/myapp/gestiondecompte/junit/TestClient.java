package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.gestiondecompte.entities.Client;
import com.myapp.gestiondecompte.metier.client.IMetierClient;

public class TestClient {

	
	private static IMetierClient metier;
	private static ClassPathXmlApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier = (IMetierClient) context.getBean("metierClient");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	@Test
	public void testAddClient() {
		
		Client c = new Client("Thomas", "Bernard", new Date(),"5 avenue de la liberté" );
		metier.addClient(c);
		Client c2 = new Client("Erik", "Dunheim", new Date(), "25 division leclerc");
		metier.addClient(c2);
		Client c3 = new Client("Julie", "Brouque", new Date(),"25 rue victorien Sardoue");
		metier.addClient(c3);
		Client c4 = new Client("Marie", "Delatour", new Date(),"25 rue victorien Sardoue");
		metier.addClient(c4);
		Client c5 = new Client("Joel", "Eden", new Date(),"25 rue victorien Sardoue");
		metier.addClient(c5);
		assertNotNull(c.getIdClient());
		
		
		
	}
/*
	@Test
	public void testDeleteClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClients() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClientsByMc() {
		fail("Not yet implemented");
	}
*/
}
