package com.transion.backend.controller.importexport;

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

import com.transion.backend.dto.exportimport.MappingDto;
import com.transion.backend.model.importexport.Mapping;
import com.transion.backend.service.importexport.MappingService;

@RestController
@RequestMapping(value = "/mapping")
public class MappingController {
	
	@Autowired
	MappingService mService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Mapping>> getAll(){
		return new ResponseEntity<List<Mapping>>(mService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Mapping> save(@RequestBody MappingDto mappingDto){
		if(mappingDto == null) {
			logger.error("Mapping is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}
		
		Mapping mapping2 = mService.save(mappingDto);
		
		if(mapping2 == null) {
			logger.error("Mapping is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Mapping>(mapping2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mapping> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}
		
		Mapping mapping = mService.findOne(id);
		
		if(mapping == null) {
			logger.error("Mapping doesn't exist.");
			return new ResponseEntity<Mapping>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Mapping>(mapping, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Mapping> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}
		
		Mapping mapping = mService.findOne(id);
		
		if(mapping == null) {
			logger.error("Mapping doesn't exist.");
			return new ResponseEntity<Mapping>(HttpStatus.NOT_FOUND);
		}
		
		mService.delete(id);
		return new ResponseEntity<Mapping>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Mapping> deleteAll(){
		mService.deleteAll();
		return new ResponseEntity<Mapping>(HttpStatus.OK);
	}
}
