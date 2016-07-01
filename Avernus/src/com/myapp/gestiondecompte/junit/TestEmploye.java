package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.metier.banque.IMetierBanque;
import com.myapp.gestiondecompte.metier.employe.IMetierEmploye;

public class TestEmploye {

	private static IMetierEmploye metier;
	private static ClassPathXmlApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier =  (IMetierEmploye) context.getBean("metierEmploye");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	/*@Test
	public void testAddEmploye() {
		Employe e1= new Employe("Brouque", "A");
		metier.addEmploye(e1);
		Employe e2=new Employe("Bernard", "B");
		metier.addEmploye(e2);
		Employe e3=new Employe("Duhem","C");
		metier.addEmploye(e3);
		Employe e4=new Employe("Martin","D");
		metier.addEmploye(e4);
		assertNotNull(e1.getIdEmploye());
	}*/

	@Test
	public void testGetEmploye() {
		List<Employe> tab = metier.getEmploye();
		assertTrue(tab.size()>0);
	}

}
