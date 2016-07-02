package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.gestiondecompte.metier.compte.IMetierCompte;
import com.myapp.gestiondecompte.metier.operation.IMetierOperation;

@SuppressWarnings("unused")
public class TestOperation {
	
	private static IMetierOperation metier;
	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier = (IMetierOperation) context.getBean("metierOperation");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

//	@Test
//	public void testSetDao() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testRetrait() {
		metier.retrait(1L, 1L, 489, new Date());
		metier.retrait(2L, 1L, 109, new Date());
	}

	@Test
	public void testVersement() {
		metier.versement(1L, 1L, 150, new Date());
		metier.versement(2L, 1L, 250, new Date());
	}

	@Test
	public void testVirement() throws ParseException {
		metier.virement(1L, 2L, 2L, 500, new Date());
		metier.virement(2L, 3L, 2L, 500, new Date());
	}

}
