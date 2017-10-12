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

import com.transion.backend.model.Sector;
import com.transion.backend.service.SectorService;

@RestController
@RequestMapping(value = "/sector")
public class SectorController {

	@Autowired
	SectorService sService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sector>> getAll(){
		return new ResponseEntity<List<Sector>>(sService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Sector> save(@RequestBody Sector sector){
		if(sector == null) {
			logger.error("Sector is null.");
			return new ResponseEntity<Sector>(HttpStatus.BAD_REQUEST);
		}
		
		Sector sector2 = sService.save(sector);
		
		if(sector2 == null) {
			logger.error("Sector is null.");
			return new ResponseEntity<Sector>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Sector>(sector2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sector> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Sector>(HttpStatus.BAD_REQUEST);
		}
		
		Sector sector = sService.findOne(id);
		
		if(sector == null) {
			logger.error("Sector doesn't exist.");
			return new ResponseEntity<Sector>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Sector>(sector, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Sector> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Sector>(HttpStatus.BAD_REQUEST);
		}
		
		Sector sector = sService.findOne(id);
		
		if(sector == null) {
			logger.error("Sector doesn't exist.");
			return new ResponseEntity<Sector>(HttpStatus.NOT_FOUND);
		}
		
		sService.delete(id);
		return new ResponseEntity<Sector>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Sector> deleteAll(){
		sService.deleteAll();
		return new ResponseEntity<Sector>(HttpStatus.OK);
	}
}
