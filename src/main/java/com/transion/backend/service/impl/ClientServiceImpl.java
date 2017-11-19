package com.transion.backend.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transion.backend.model.Client;
import com.transion.backend.repository.ClientRepository;
import com.transion.backend.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client findOne(Long id) {
		return clientRepository.findOne(id);
	}

	@Override
	public List<Client> findAll() {
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		clientRepository.delete(id);
	}

	@Override
	public void delete(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public void deleteAll() {
		clientRepository.deleteAll();
	}

	@Override
	public List<Client> save(List<Client> clients) {
		return (List<Client>) clientRepository.save(clients);
	}

	@Override
	public void deleteAll(List<Client> clients) {
		clientRepository.delete(clients);
	}

	@Override
	public List<Client> findByStartingLetter(String letter) {
		List<Client> clients = em
				.createNativeQuery("SELECT * FROM CLIENT WHERE NAME LIKE ?1 ORDER BY NAME ASC", Client.class)
				.setParameter(1, letter + "%").getResultList();
		return clients;
	}
	public Client findByExternalUniqueKey(String key) {
		return clientRepository.findByExternalUniqueKey(key);
	}

}
