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
import org.springframework.web.bind.annotation.RestController;

import com.transion.backend.model.Transaction;
import com.transion.backend.service.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

	@Autowired
	TransactionService tService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getAll(){
		return new ResponseEntity<List<Transaction>>(tService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Transaction> save(@RequestBody Transaction transaction){
		if(transaction == null) {
			logger.error("Transaction is null.");
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		}
		
		Transaction transaction2 = tService.save(transaction);
		
		if(transaction2 == null) {
			logger.error("Transaction is null.");
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Transaction>(transaction2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Transaction> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		}
		
		Transaction transaction = tService.findOne(id);
		
		if(transaction == null) {
			logger.error("Transaction doesn't exist.");
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Transaction> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		}
		
		Transaction transaction = tService.findOne(id);
		
		if(transaction == null) {
			logger.error("Transaction doesn't exist.");
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}
		
		tService.delete(id);
		return new ResponseEntity<Transaction>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Transaction> deleteAll(){
		tService.deleteAll();
		return new ResponseEntity<Transaction>(HttpStatus.OK);
	}
}
