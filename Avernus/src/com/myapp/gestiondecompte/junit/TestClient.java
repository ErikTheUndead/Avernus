package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

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
//	@Test
//	public void testAddClient() {
//		System.out.println("ezfafeaeafzafzaefaazfafa");
//		Client c = new Client("Thomas", "Bernard", new Date(),"5 avenue de la liberté" );
//		metier.addClient(c);
//		Client c2 = new Client("Erik", "Duhem", new Date(), "25 division leclerc");
//		metier.addClient(c2);
//		Client c3 = new Client("Julie", "Brouque", new Date(),"25 rue victorien Sardoue");
//		metier.addClient(c3);
//		Client c4 = new Client("Marie", "Delatour", new Date(),"25 rue victorien Sardoue");
//		metier.addClient(c4);
//		Client c5 = new Client("Joel", "Eden", new Date(),"25 rue victorien Sardoue");
//		metier.addClient(c5);
//		assertNotNull(c.getIdClient());
//		
//		
//		
//	}

//	@Test
//	public void testGetClientById(){
//		
//		Client c8 = metier.getClientById(1L);
//		assertNotNull(c8);
//	}
	
//	@Test
//	public void testDeleteClient() {
//		Client c6 = new Client("Joel", "Eden", new Date(),"25 rue victorien Sardoue");
//		c6=metier.addClient(c6);
//		metier.deleteClient(c6.getIdClient());
//		Client c7 = metier.getClientById(c6.getIdClient());
//		assertNull(c7);
//
//	}

//	@Test
//	public void testUpdateClient() {
//		Client c10 = metier.getClientById(2L);
//		c10.setNomClient("azerty");
//		metier.updateClient(c10);
//		assertTrue(c10.getNomClient()=="azerty");		
//		
//	}

//	@Test
//	public void testGetClients() {
//		List<Client> list = metier.getClients();
//		assertNotNull(list);
//		
//	}

//	@Test
//	public void testGetClientsByMc() {
//		Client c5 = new Client("eeeee", "Eden", new Date(),"25 rue victorien Sardoue");
//		metier.addClient(c5);
//		List<Client> list = metier.getClientsByMc("eeeee");
//		assertTrue(list.size()==1);
//	}

}
