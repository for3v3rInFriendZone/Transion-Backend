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

import com.transion.backend.model.Delivery;
import com.transion.backend.service.DeliveryService;

@RestController
@RequestMapping(value = "/delivery")
public class DeliveryController {

	@Autowired
	DeliveryService dService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Delivery>> getAll(){
		return new ResponseEntity<List<Delivery>>(dService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Delivery> save(@RequestBody Delivery delivery){
		if(delivery == null) {
			logger.error("Delivery is null.");
			return new ResponseEntity<Delivery>(HttpStatus.BAD_REQUEST);
		}
		
		Delivery delivery2 = dService.save(delivery);
		
		if(delivery2 == null) {
			logger.error("Delivery is null.");
			return new ResponseEntity<Delivery>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Delivery>(delivery2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Delivery> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Delivery>(HttpStatus.BAD_REQUEST);
		}
		
		Delivery delivery = dService.findOne(id);
		
		if(delivery == null) {
			logger.error("Delivery doesn't exist.");
			return new ResponseEntity<Delivery>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Delivery>(delivery, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Delivery> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Delivery>(HttpStatus.BAD_REQUEST);
		}
		
		Delivery delivery = dService.findOne(id);
		
		if(delivery == null) {
			logger.error("Delivery doesn't exist.");
			return new ResponseEntity<Delivery>(HttpStatus.NOT_FOUND);
		}
		
		dService.delete(id);
		return new ResponseEntity<Delivery>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Delivery> deleteAll(){
		dService.deleteAll();
		return new ResponseEntity<Delivery>(HttpStatus.OK);
	}
}
