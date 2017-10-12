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

import com.transion.backend.model.ResponsibleUser;
import com.transion.backend.service.ResponsibleUserService;

@RestController
@RequestMapping(value = "/responsibleuser")
public class ResponsibleUserController {

	@Autowired
	ResponsibleUserService ruService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ResponsibleUser>> getAll(){
		return new ResponseEntity<List<ResponsibleUser>>(ruService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponsibleUser> save(@RequestBody ResponsibleUser responsibleUser){
		if(responsibleUser == null) {
			logger.error("ResponsibleUser is null.");
			return new ResponseEntity<ResponsibleUser>(HttpStatus.BAD_REQUEST);
		}
		
		ResponsibleUser responsibleUser2 = ruService.save(responsibleUser);
		
		if(responsibleUser2 == null) {
			logger.error("ResponsibleUser is null.");
			return new ResponseEntity<ResponsibleUser>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ResponsibleUser>(responsibleUser2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponsibleUser> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ResponsibleUser>(HttpStatus.BAD_REQUEST);
		}
		
		ResponsibleUser responsibleUser = ruService.findOne(id);
		
		if(responsibleUser == null) {
			logger.error("ResponsibleUser doesn't exist.");
			return new ResponseEntity<ResponsibleUser>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ResponsibleUser>(responsibleUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<ResponsibleUser> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ResponsibleUser>(HttpStatus.BAD_REQUEST);
		}
		
		ResponsibleUser responsibleUser = ruService.findOne(id);
		
		if(responsibleUser == null) {
			logger.error("ResponsibleUser doesn't exist.");
			return new ResponseEntity<ResponsibleUser>(HttpStatus.BAD_REQUEST);
		}
		
		ruService.delete(id);
		return new ResponseEntity<ResponsibleUser>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<ResponsibleUser> deleteAll(){
		ruService.deleteAll();
		return new ResponseEntity<ResponsibleUser>(HttpStatus.OK);
	}
}
