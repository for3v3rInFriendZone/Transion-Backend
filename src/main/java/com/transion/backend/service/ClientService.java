package com.transion.backend.service;

import java.util.List;

import com.transion.backend.model.Client;

public interface ClientService {

	public Client save(Client client);
	
	public List<Client> save(List<Client> clients);
	
	public Client findOne(Long id);
	
	public List<Client> findAll();
	
	public void delete(Long id);
	
	public void delete(Client client);
	
	public void deleteAll();
	
	public void deleteAll(List<Client> clients);
	
	public List<Client> findByStartingLetter(String letter);

	public Client findByExternalUniqueKey(String key);

}
