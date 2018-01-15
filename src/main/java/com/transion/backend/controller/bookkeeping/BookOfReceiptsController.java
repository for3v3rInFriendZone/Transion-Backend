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

import com.transion.backend.model.bookkeeping.BookOfReceipts;
import com.transion.backend.service.bookkeeping.BookOfReceiptsService;

@RestController
@RequestMapping(value = "/bookofreceipts")
public class BookOfReceiptsController {

	@Autowired
	BookOfReceiptsService bors;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BookOfReceipts>> getAll(){
		return new ResponseEntity<List<BookOfReceipts>>(bors.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BookOfReceipts> save(@RequestBody BookOfReceipts bookOfReceipts){
		if(bookOfReceipts == null) {
			logger.error("bookOfReceipts is null.");
			return new ResponseEntity<BookOfReceipts>(HttpStatus.BAD_REQUEST);
		}
		
		BookOfReceipts bookOfReceipts2 = bors.save(bookOfReceipts);
		
		if(bookOfReceipts2 == null) {
			logger.error("bookOfReceipts is null.");
			return new ResponseEntity<BookOfReceipts>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<BookOfReceipts>(bookOfReceipts, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookOfReceipts> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<BookOfReceipts>(HttpStatus.BAD_REQUEST);
		}
		
		BookOfReceipts bookOfReceipts= bors.findOne(id);
		
		if(bookOfReceipts == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<BookOfReceipts>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BookOfReceipts>(bookOfReceipts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<BookOfReceipts> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<BookOfReceipts>(HttpStatus.BAD_REQUEST);
		}
		
		BookOfReceipts bookOfReceipts = bors.findOne(id);
		
		if(bookOfReceipts == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<BookOfReceipts>(HttpStatus.NOT_FOUND);
		}
		
		bors.delete(id);
		return new ResponseEntity<BookOfReceipts>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<BookOfReceipts> deleteAll(){
		bors.deleteAll();
		return new ResponseEntity<BookOfReceipts>(HttpStatus.OK);
	}
}
