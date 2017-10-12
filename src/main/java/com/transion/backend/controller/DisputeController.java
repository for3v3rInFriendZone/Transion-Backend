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

import com.transion.backend.model.Dispute;
import com.transion.backend.service.DisputeService;

@RestController
@RequestMapping(value = "/dispute")
public class DisputeController {

	@Autowired
	DisputeService dService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Dispute>> getAll(){
		return new ResponseEntity<List<Dispute>>(dService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Dispute> save(@RequestBody Dispute dispute){
		if(dispute == null) {
			logger.error("t is null.");
			return new ResponseEntity<Dispute>(HttpStatus.BAD_REQUEST);
		}
		
		Dispute dispute2 = dService.save(dispute);
		
		if(dispute2 == null) {
			logger.error("Dispute is null.");
			return new ResponseEntity<Dispute>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Dispute>(dispute2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Dispute> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Dispute>(HttpStatus.BAD_REQUEST);
		}
		
		Dispute dispute = dService.findOne(id);
		
		if(dispute == null) {
			logger.error("Dispute doesn't exist.");
			return new ResponseEntity<Dispute>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Dispute>(dispute, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Dispute> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Dispute>(HttpStatus.BAD_REQUEST);
		}
		
		Dispute dispute = dService.findOne(id);
		
		if(dispute == null) {
			logger.error("Dispute doesn't exist.");
			return new ResponseEntity<Dispute>(HttpStatus.NOT_FOUND);
		}
		
		dService.delete(id);
		return new ResponseEntity<Dispute>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Dispute> deleteAll(){
		dService.deleteAll();
		return new ResponseEntity<Dispute>(HttpStatus.OK);
	}
}
