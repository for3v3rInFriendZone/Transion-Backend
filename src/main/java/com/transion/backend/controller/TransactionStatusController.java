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

import com.transion.backend.model.TransactionStatus;
import com.transion.backend.service.TransactionStatusService;

@RestController
@RequestMapping(value = "/transactionstatus")
public class TransactionStatusController {

	@Autowired
	TransactionStatusService tsService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TransactionStatus>> getAll(){
		return new ResponseEntity<List<TransactionStatus>>(tsService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TransactionStatus> save(@RequestBody TransactionStatus transactionStatus){
		if(transactionStatus == null) {
			logger.error("TransactionStatus is null.");
			return new ResponseEntity<TransactionStatus>(HttpStatus.BAD_REQUEST);
		}
		
		TransactionStatus transactionStatus2 = tsService.save(transactionStatus);
		
		if(transactionStatus2 == null) {
			logger.error("TransactionStatus is null.");
			return new ResponseEntity<TransactionStatus>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<TransactionStatus>(transactionStatus2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TransactionStatus> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<TransactionStatus>(HttpStatus.BAD_REQUEST);
		}
		
		TransactionStatus transactionStatus = tsService.findOne(id);
		
		if(transactionStatus == null) {
			logger.error("TransactionStatus doesn't exist.");
			return new ResponseEntity<TransactionStatus>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TransactionStatus>(transactionStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<TransactionStatus> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<TransactionStatus>(HttpStatus.BAD_REQUEST);
		}
		
		TransactionStatus transactionStatus = tsService.findOne(id);
		
		if(transactionStatus == null) {
			logger.error("TransactionStatus doesn't exist.");
			return new ResponseEntity<TransactionStatus>(HttpStatus.NOT_FOUND);
		}
		
		tsService.delete(id);
		return new ResponseEntity<TransactionStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<TransactionStatus> deleteAll(){
		tsService.deleteAll();
		return new ResponseEntity<TransactionStatus>(HttpStatus.OK);
	}
}
