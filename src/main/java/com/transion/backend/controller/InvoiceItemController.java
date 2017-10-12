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

import com.transion.backend.model.InvoiceItem;
import com.transion.backend.service.InvoiceItemService;

@RestController
@RequestMapping(value = "/invoiceitem")
public class InvoiceItemController {

	@Autowired
	InvoiceItemService itService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InvoiceItem>> getAll(){
		return new ResponseEntity<List<InvoiceItem>>(itService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<InvoiceItem> save(@RequestBody InvoiceItem invoiceItem){
		if(invoiceItem == null) {
			logger.error("InvoiceItem is null.");
			return new ResponseEntity<InvoiceItem>(HttpStatus.BAD_REQUEST);
		}
		
		InvoiceItem invoiceItem2 = itService.save(invoiceItem);
		
		if(invoiceItem2 == null) {
			logger.error("InvoiceItem is null.");
			return new ResponseEntity<InvoiceItem>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<InvoiceItem>(invoiceItem2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InvoiceItem> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<InvoiceItem>(HttpStatus.BAD_REQUEST);
		}
		
		InvoiceItem invoiceItem = itService.findOne(id);
		
		if(invoiceItem == null) {
			logger.error("InvoiceItem doesn't exist.");
			return new ResponseEntity<InvoiceItem>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<InvoiceItem>(invoiceItem, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<InvoiceItem> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<InvoiceItem>(HttpStatus.BAD_REQUEST);
		}
		
		InvoiceItem invoiceItem = itService.findOne(id);
		
		if(invoiceItem == null) {
			logger.error("InvoiceItem doesn't exist.");
			return new ResponseEntity<InvoiceItem>(HttpStatus.NOT_FOUND);
		}
		
		itService.delete(id);
		return new ResponseEntity<InvoiceItem>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<InvoiceItem> deleteAll(){
		itService.deleteAll();
		return new ResponseEntity<InvoiceItem>(HttpStatus.OK);
	}
}
