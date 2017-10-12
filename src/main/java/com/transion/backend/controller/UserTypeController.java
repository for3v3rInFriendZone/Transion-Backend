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

import com.transion.backend.model.UserType;
import com.transion.backend.service.UserTypeService;

@RestController
@RequestMapping(value = "/usertype")
public class UserTypeController {

	@Autowired
	UserTypeService utService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserType>> getAll(){
		return new ResponseEntity<List<UserType>>(utService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserType> save(@RequestBody UserType userType){
		if(userType == null) {
			logger.error("UserType is null.");
			return new ResponseEntity<UserType>(HttpStatus.BAD_REQUEST);
		}
		
		UserType userType2 = utService.save(userType);
		
		if(userType2 == null) {
			logger.error("UserType is null.");
			return new ResponseEntity<UserType>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<UserType>(userType2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserType> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<UserType>(HttpStatus.BAD_REQUEST);
		}
		
		UserType userType = utService.findOne(id);
		
		if(userType == null) {
			logger.error("UserType doesn't exist.");
			return new ResponseEntity<UserType>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserType>(userType, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<UserType> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<UserType>(HttpStatus.BAD_REQUEST);
		}
		
		UserType userType = utService.findOne(id);
		
		if(userType == null) {
			logger.error("UserType doesn't exist.");
			return new ResponseEntity<UserType>(HttpStatus.NOT_FOUND);
		}
		
		utService.delete(id);
		return new ResponseEntity<UserType>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<UserType> deleteAll(){
		utService.deleteAll();
		return new ResponseEntity<UserType>(HttpStatus.OK);
	}
}
