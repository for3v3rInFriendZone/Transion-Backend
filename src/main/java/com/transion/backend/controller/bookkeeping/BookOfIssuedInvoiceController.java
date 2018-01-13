package com.transion.backend.controller.bookkeeping;

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

import com.transion.backend.model.bookkeeping.BookOfIssuedInvoice;
import com.transion.backend.service.bookkeeping.BookOfIssuedInvoiceService;


@RestController
@RequestMapping(value = "/bookofinvoice")
public class BookOfIssuedInvoiceController {

	@Autowired
	BookOfIssuedInvoiceService boiis;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BookOfIssuedInvoice>> getAll(){
		return new ResponseEntity<List<BookOfIssuedInvoice>>(boiis.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BookOfIssuedInvoice> save(@RequestBody BookOfIssuedInvoice bookOfInvoices){
		if(bookOfInvoices == null) {
			logger.error("bookOfInvoices is null.");
			return new ResponseEntity<BookOfIssuedInvoice>(HttpStatus.BAD_REQUEST);
		}
		
		BookOfIssuedInvoice bookOfInvoices2 = boiis.save(bookOfInvoices);
		
		if(bookOfInvoices2 == null) {
			logger.error("bookOfInvoices is null.");
			return new ResponseEntity<BookOfIssuedInvoice>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<BookOfIssuedInvoice>(bookOfInvoices, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookOfIssuedInvoice> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<BookOfIssuedInvoice>(HttpStatus.BAD_REQUEST);
		}
		
		BookOfIssuedInvoice bookOfInvoices= boiis.findOne(id);
		
		if(bookOfInvoices == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<BookOfIssuedInvoice>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BookOfIssuedInvoice>(bookOfInvoices, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<BookOfIssuedInvoice> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<BookOfIssuedInvoice>(HttpStatus.BAD_REQUEST);
		}
		
		BookOfIssuedInvoice bookOfInvoices = boiis.findOne(id);
		
		if(bookOfInvoices == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<BookOfIssuedInvoice>(HttpStatus.NOT_FOUND);
		}
		
		boiis.delete(id);
		return new ResponseEntity<BookOfIssuedInvoice>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<BookOfIssuedInvoice> deleteAll(){
		boiis.deleteAll();
		return new ResponseEntity<BookOfIssuedInvoice>(HttpStatus.OK);
	}
}
