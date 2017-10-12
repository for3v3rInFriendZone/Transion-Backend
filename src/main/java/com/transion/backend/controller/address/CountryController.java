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

import com.transion.backend.model.address.Country;
import com.transion.backend.service.address.CountryService;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
	
	@Autowired
	CountryService cService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getAll(){
		return new ResponseEntity<List<Country>>(cService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Country> save(@RequestBody Country country){
		if(country == null) {
			logger.error("Country is null.");
			return new ResponseEntity<Country>(HttpStatus.BAD_REQUEST);
		}
		
		Country country2 = cService.save(country);
		
		if(country2 == null) {
			logger.error("Country is null.");
			return new ResponseEntity<Country>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Country>(country2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Country> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Country>(HttpStatus.BAD_REQUEST);
		}
		
		Country country = cService.findOne(id);
		
		if(country == null) {
			logger.error("Country doesn't exist.");
			return new ResponseEntity<Country>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Country> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Country>(HttpStatus.BAD_REQUEST);
		}
		
		Country country = cService.findOne(id);
		
		if(country == null) {
			logger.error("Country doesn't exist.");
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
		
		cService.delete(id);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Country> deleteAll(){
		cService.deleteAll();
		return new ResponseEntity<Country>(HttpStatus.OK);
	}
}
