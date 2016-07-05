package com.myapp.gestiondecompte.model;

import java.util.ArrayList;
import java.util.List;

import com.myapp.gestiondecompte.entities.Client;

public class ClientModel {

	
	private Long idClient;
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	private String motCle;
	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	private List<Client> listClient= new ArrayList<>();
	private List<Client> listClientByMc= new ArrayList<>();
	private String ExceptionByMc;
	public String getExceptionByMc() {
		return ExceptionByMc;
	}
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setExceptionByMc(String exceptionByMc) {
		ExceptionByMc = exceptionByMc;
	}

	public List<Client> getListClientByMc() {
		return listClientByMc;
	}

	public void setListClientByMc(List<Client> listClientByMc) {
		this.listClientByMc = listClientByMc;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	private String ExceptionPersoById;

	public String getExceptionPersoById() {
		return ExceptionPersoById;
	}

	public void setExceptionPersoById(String exceptionPersoById) {
		ExceptionPersoById = exceptionPersoById;
	}
	
}
