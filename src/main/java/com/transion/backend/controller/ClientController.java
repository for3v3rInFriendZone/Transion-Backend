package com.transion.backend.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transion.backend.model.Client;
import com.transion.backend.model.Transaction;
import com.transion.backend.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAll() {
		
		return new ResponseEntity<List<Client>>(clientService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Client> save(@RequestBody Client client) {
		
		if (client == null) {
			logger.error("Client is null.");
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Client>(clientService.save(client), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findOne(@PathVariable Long id) {
		
		if (id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
		}

		Client client = clientService.findOne(id);

		if (client == null) {
			logger.error("Client doesn't exist.");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> delete(@PathVariable Long id) {
		
		if (id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
		}

		Client client = clientService.findOne(id);

		if (client == null) {
			logger.error("Client doesn't exists.");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		clientService.delete(id);
		return new ResponseEntity<Client>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Client> deleteAll() {
		
		clientService.deleteAll();
		return new ResponseEntity<Client>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Client> delete(@RequestBody Client client) {
		
		if (client == null) {
			logger.error("Client doesn't exists.");
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
		}

		clientService.delete(client);
		return new ResponseEntity<Client>(HttpStatus.OK);
	}

	@RequestMapping(value = "/letter", params = { "letter" }, method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findByStartingLetter(@RequestParam(value = "letter") String letter) {

		if (letter == null || letter == "") {
			logger.error("letter is null or empty.");
			return new ResponseEntity<List<Client>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<Client>>(clientService.findByStartingLetter(letter), HttpStatus.OK);
	}
}
