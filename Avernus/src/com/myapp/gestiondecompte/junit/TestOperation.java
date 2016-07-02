package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.metier.compte.IMetierCompte;
import com.myapp.gestiondecompte.metier.operation.IMetierOperation;

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
	public void testRetrait() throws ExceptionPerso {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		metier.retrait(1L, 1L, 50, new Date());
		metier.retrait(2L, 1L, 150, new Date());
	}

	@Test
	public void testVersement() throws ExceptionPerso {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		metier.versement(1L, 1L, 50, new Date());
		metier.versement(2L, 1L, 150, new Date());
	}

	@Test
	public void testVirement() throws ParseException, ExceptionPerso {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		metier.virement(1L, 2L, 2L, 400, sdf.parse("23.06.2016"));
		metier.virement(2L, 3L, 2L, 400, sdf.parse("23.06.2016"));
	}

}
