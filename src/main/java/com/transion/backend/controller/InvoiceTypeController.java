package com.transion.backend.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invoicetype")
public class InvoiceTypeController {


	/*Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<T> getAll(){
		return new ResponseEntity<List<E>>(Service.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<T> save(@RequestBody T t){
		if(t == null) {
			logger.error("t is null.");
			return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
		}
		
		T t = Service.save(t);
		
		if(t == null) {
			logger.error("t is null.");
			return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<T>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<T> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
		}
		
		T t = Service.findOne(id);
		
		if(t == null) {
			logger.error("T doesn't exist.");
			return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<T>(t, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<T> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
		}
		
		T t = Service.findOne(id);
		
		if(t == null) {
			logger.error("T doesn't exist.");
			return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
		}
		
		Service.delete(id);
		return new ResponseEntity<T>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<T> deleteAll(){
		Service.deleteAll();
		return new ResponseEntity<T>(HttpStatus.OK);
	}*/
}
