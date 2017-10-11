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

import com.transion.backend.model.CustomForm;
import com.transion.backend.service.CustomFormService;

@RestController
@RequestMapping(value = "customform")
public class CustomFormController {

	@Autowired
	CustomFormService cfService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomForm>> getAll(){
		return new ResponseEntity<List<CustomForm>>(cfService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CustomForm> save(@RequestBody CustomForm customForm){
		if(customForm == null) {
			logger.error("CustomForm is null.");
			return new ResponseEntity<CustomForm>(HttpStatus.BAD_REQUEST);
		}
		
		CustomForm customForm2 = cfService.save(customForm);
		
		if(customForm2 == null) {
			logger.error("CustomForm is null.");
			return new ResponseEntity<CustomForm>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<CustomForm>(customForm2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomForm> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<CustomForm>(HttpStatus.BAD_REQUEST);
		}
		
		CustomForm customForm = cfService.findOne(id);
		
		if(customForm == null) {
			logger.error("CustomForm doesn't exist.");
			return new ResponseEntity<CustomForm>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<CustomForm>(customForm, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<CustomForm> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<CustomForm>(HttpStatus.BAD_REQUEST);
		}
		
		CustomForm customForm = cfService.findOne(id);
		
		if(customForm == null) {
			logger.error("CustomForm doesn't exist.");
			return new ResponseEntity<CustomForm>(HttpStatus.BAD_REQUEST);
		}
		
		cfService.delete(id);
		return new ResponseEntity<CustomForm>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<CustomForm> deleteAll(){
		cfService.deleteAll();
		return new ResponseEntity<CustomForm>(HttpStatus.OK);
	}
}
