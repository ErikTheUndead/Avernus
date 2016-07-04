package com.myapp.gestiondecompte.junit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.gestiondecompte.dao.Exception.ExceptionPerso;
import com.myapp.gestiondecompte.entities.Employe;
import com.myapp.gestiondecompte.entities.Groupe;
import com.myapp.gestiondecompte.metier.banque.IMetierBanque;
import com.myapp.gestiondecompte.metier.groupe.IMetierGroupe;

public class TestGroupe {

	private static IMetierGroupe metier;
	private static ClassPathXmlApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier =  (IMetierGroupe) context.getBean("metierGroupe");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testAddGroupe() {
		Groupe g1=new Groupe("LeGroupe1");
		metier.addGroupe(g1);
		Groupe g2=new Groupe("LeGroupe2");
		metier.addGroupe(g2);
		Groupe g3=new Groupe("LeGroupe3");
		metier.addGroupe(g3);
		assertNotNull(g1.getIdGroupe());
	}
	/*
	@Test
	public void testAddEmployeGroupe() {
		metier.addEmployeGroupe(3L, 3L);
		List<Employe> tab=metier.getEmployesGroupe(3L);
		assertTrue(tab.size()>0);
		
	}*/

	/*@Test
	public void testGetGroupe() {
		List<Groupe> tab = metier.getGroupe();
		assertTrue(tab.size()>0);
	}*/
/*
	@Test
	public void testGetEmployesGroupe() throws ExceptionPerso {
		List<Employe> tab = metier.getEmployesGroupe(3L);
		assertTrue(tab.size()>0);
	}
	*/
}
