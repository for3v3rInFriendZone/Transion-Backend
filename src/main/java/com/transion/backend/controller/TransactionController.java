package com.transion.backend.controller;

import java.util.Calendar;
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
import com.transion.backend.model.scenario.Task;
import com.transion.backend.service.ClientService;
import com.transion.backend.service.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

	@Autowired
	TransactionService tService;

	@Autowired
	ClientService clientSer;

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getAll() {
		return new ResponseEntity<List<Transaction>>(tService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Transaction> save(@RequestBody Transaction transaction) {
		if (transaction == null) {
			logger.error("Transaction is null.");
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		}

		Transaction transaction2 = tService.save(transaction);

		if (transaction2 == null) {
			logger.error("Transaction is null.");
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Transaction>(transaction2, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Transaction> findOne(@PathVariable Long id) {
		if (id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		}

		Transaction transaction = tService.findOne(id);

		if (transaction == null) {
			logger.error("Transaction doesn't exist.");
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Transaction> delete(@PathVariable Long id) {
		if (id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		}

		Transaction transaction = tService.findOne(id);

		if (transaction == null) {
			logger.error("Transaction doesn't exist.");
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}

		tService.delete(id);
		return new ResponseEntity<Transaction>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Transaction> deleteAll() {
		tService.deleteAll();
		return new ResponseEntity<Transaction>(HttpStatus.OK);
	}

	@RequestMapping(value = "/client/{idClient}", params = { "typeOfTransactons" }, method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> findTranactionsByClient(@PathVariable Long idClient,
			@RequestParam(value = "typeOfTransactons") String type) {

		List<Transaction> transactions = null;

		if (idClient == null) {
			logger.error("Id is null.");
			return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
		}
		Client client = clientSer.findOne(idClient);

		if (client == null) {
			logger.error("Client is null.");
			return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
		}
		transactions = tService.findByClient(client);

		if (type.equals("notPaid")) {
			transactions = tService.getOnlyNotPaidTransactions(transactions);
		} else if (type.equals("paid")) {
			transactions = tService.getOnlyPaidTransactions(transactions);
		}

		if (transactions == null) {
			logger.error("Transactions doesn't exist.");
			return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
		}
		tService.save(transactions);

		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public ResponseEntity<List<Transaction>> findTranactionsByTask(@RequestBody Task task) {

		if (task == null) {
			logger.error("Task is null.");
			return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<Transaction>>(tService.findByTask(task), HttpStatus.OK);
	}

}
