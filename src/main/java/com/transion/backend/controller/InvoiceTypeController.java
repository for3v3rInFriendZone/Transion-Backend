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

import com.transion.backend.model.InvoiceType;
import com.transion.backend.service.InvoiceTypeService;

@RestController
@RequestMapping(value = "/invoicetype")
public class InvoiceTypeController {

	@Autowired
	InvoiceTypeService itService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InvoiceType>> getAll(){
		return new ResponseEntity<List<InvoiceType>>(itService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<InvoiceType> save(@RequestBody InvoiceType invoiceType){
		if(invoiceType == null) {
			logger.error("InvoiceType is null.");
			return new ResponseEntity<InvoiceType>(HttpStatus.BAD_REQUEST);
		}
		
		InvoiceType invoiceType2 = itService.save(invoiceType);
		
		if(invoiceType2 == null) {
			logger.error("InvoiceType is null.");
			return new ResponseEntity<InvoiceType>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<InvoiceType>(invoiceType2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InvoiceType> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<InvoiceType>(HttpStatus.BAD_REQUEST);
		}
		
		InvoiceType invoiceType = itService.findOne(id);
		
		if(invoiceType == null) {
			logger.error("InvoiceType doesn't exist.");
			return new ResponseEntity<InvoiceType>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<InvoiceType>(invoiceType, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<InvoiceType> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<InvoiceType>(HttpStatus.BAD_REQUEST);
		}
		
		InvoiceType invoiceType = itService.findOne(id);
		
		if(invoiceType == null) {
			logger.error("InvoiceType doesn't exist.");
			return new ResponseEntity<InvoiceType>(HttpStatus.NOT_FOUND);
		}
		
		itService.delete(id);
		return new ResponseEntity<InvoiceType>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<InvoiceType> deleteAll(){
		itService.deleteAll();
		return new ResponseEntity<InvoiceType>(HttpStatus.OK);
	}
}
