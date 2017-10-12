package com.transion.backend.controller.address;

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

import com.transion.backend.model.address.Address;
import com.transion.backend.service.address.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
	
	@Autowired
	AddressService aService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Address>> getAll(){
		return new ResponseEntity<List<Address>>(aService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Address> save(@RequestBody Address address){
		if(address == null) {
			logger.error("Address is null.");
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
		
		Address address2 = aService.save(address);
		
		if(address2 == null) {
			logger.error("Address is null.");
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Address>(address2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Address> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
		
		Address address = aService.findOne(id);
		
		if(address == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Address> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
		
		Address address = aService.findOne(id);
		
		if(address == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		
		aService.delete(id);
		return new ResponseEntity<Address>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Address> deleteAll(){
		aService.deleteAll();
		return new ResponseEntity<Address>(HttpStatus.OK);
	}
}
