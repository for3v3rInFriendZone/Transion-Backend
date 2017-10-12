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

import com.transion.backend.model.address.City;
import com.transion.backend.service.address.CityService;

@RestController
@RequestMapping(value = "/city")
public class CityController {
	
	@Autowired
	CityService cService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<City>> getAll(){
		return new ResponseEntity<List<City>>(cService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<City> save(@RequestBody City city){
		if(city == null) {
			logger.error("City is null.");
			return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
		}
		
		City city2 = cService.save(city);
		
		if(city2 == null) {
			logger.error("City is null.");
			return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<City>(city2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
		}
		
		City city = cService.findOne(id);
		
		if(city == null) {
			logger.error("City doesn't exist.");
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<City> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
		}
		
		City city = cService.findOne(id);
		
		if(city == null) {
			logger.error("City doesn't exist.");
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}
		
		cService.delete(id);
		return new ResponseEntity<City>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<City> deleteAll(){
		cService.deleteAll();
		return new ResponseEntity<City>(HttpStatus.OK);
	}
}
