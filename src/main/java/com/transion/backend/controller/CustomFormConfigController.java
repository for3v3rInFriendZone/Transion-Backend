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

import com.transion.backend.model.CustomFormConfig;
import com.transion.backend.service.CustomFormConfigService;

@RequestMapping(value = "/customformconfig")
public class CustomFormConfigController {

	@Autowired
	CustomFormConfigService cfcService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomFormConfig>> getAll(){
		return new ResponseEntity<List<CustomFormConfig>>(cfcService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CustomFormConfig> save(@RequestBody CustomFormConfig cfc){
		if(cfc == null) {
			logger.error("CustomFormConfig is null.");
			return new ResponseEntity<CustomFormConfig>(HttpStatus.BAD_REQUEST);
		}
		
		CustomFormConfig cfco = cfcService.save(cfc);
		
		if(cfco == null) {
			logger.error("CustomFormConfig doesn't exist.");
			return new ResponseEntity<CustomFormConfig>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<CustomFormConfig>(cfco, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomFormConfig> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<CustomFormConfig>(HttpStatus.BAD_REQUEST);
		}
		
		CustomFormConfig cfc = cfcService.findOne(id);
		
		if(cfc == null) {
			logger.error("CustomFormConfig doesn't exist.");
			return new ResponseEntity<CustomFormConfig>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CustomFormConfig>(cfc, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<CustomFormConfig> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<CustomFormConfig>(HttpStatus.BAD_REQUEST);
		}
		
		CustomFormConfig cfc = cfcService.findOne(id);
		
		if(cfc == null) {
			logger.error("CustomFormConfig doesn't exist.");
			return new ResponseEntity<CustomFormConfig>(HttpStatus.NOT_FOUND);
		}
		
		cfcService.delete(id);
		return new ResponseEntity<CustomFormConfig>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<CustomFormConfig> deleteAll(){
		cfcService.deleteAll();
		return new ResponseEntity<CustomFormConfig>(HttpStatus.OK);
	}
}
