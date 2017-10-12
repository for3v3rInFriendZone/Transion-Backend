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

import com.transion.backend.model.Invoice;
import com.transion.backend.service.InvoiceService;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

	@Autowired
	InvoiceService iService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getAll(){
		return new ResponseEntity<List<Invoice>>(iService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Invoice> save(@RequestBody Invoice invoice){
		if(invoice == null) {
			logger.error("Invoice is null.");
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
		
		Invoice invoice2 = iService.save(invoice);
		
		if(invoice2 == null) {
			logger.error("Invoice is null.");
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Invoice>(invoice2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Invoice> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
		
		Invoice invoice = iService.findOne(id);
		
		if(invoice == null) {
			logger.error("T doesn't exist.");
			return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Invoice> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
		
		Invoice invoice = iService.findOne(id);
		
		if(invoice == null) {
			logger.error("Invoice doesn't exist.");
			return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
		}
		
		iService.delete(id);
		return new ResponseEntity<Invoice>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Invoice> deleteAll(){
		iService.deleteAll();
		return new ResponseEntity<Invoice>(HttpStatus.OK);
	}
}
