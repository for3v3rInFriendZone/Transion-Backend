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

import com.transion.backend.model.Tax;
import com.transion.backend.service.TaxService;

@RestController
@RequestMapping(value = "/tax")
public class TaxController {

	@Autowired
	TaxService tService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Tax>> getAll(){
		return new ResponseEntity<List<Tax>>(tService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Tax> save(@RequestBody Tax tax){
		if(tax == null) {
			logger.error("Tax is null.");
			return new ResponseEntity<Tax>(HttpStatus.BAD_REQUEST);
		}
		
		Tax tax2 = tService.save(tax);
		
		if(tax2 == null) {
			logger.error("Tax is null.");
			return new ResponseEntity<Tax>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Tax>(tax2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tax> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Tax>(HttpStatus.BAD_REQUEST);
		}
		
		Tax tax = tService.findOne(id);
		
		if(tax == null) {
			logger.error("Tax doesn't exist.");
			return new ResponseEntity<Tax>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Tax>(tax, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Tax> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Tax>(HttpStatus.BAD_REQUEST);
		}
		
		Tax tax = tService.findOne(id);
		
		if(tax == null) {
			logger.error("Tax doesn't exist.");
			return new ResponseEntity<Tax>(HttpStatus.NOT_FOUND);
		}
		
		tService.delete(id);
		return new ResponseEntity<Tax>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Tax> deleteAll(){
		tService.deleteAll();
		return new ResponseEntity<Tax>(HttpStatus.OK);
	}
}
