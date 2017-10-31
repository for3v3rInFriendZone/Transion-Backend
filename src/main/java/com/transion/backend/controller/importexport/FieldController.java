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

import com.transion.backend.model.importexport.Field;
import com.transion.backend.service.importexport.FieldService;
import com.transion.backend.service.importexport.impl.MappingType;

@RestController
@RequestMapping(value = "/field")
public class FieldController {
	
	@Autowired
	FieldService fService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Field>> getAll(){
		return new ResponseEntity<List<Field>>(fService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Field> save(@RequestBody Field field){
		if(field == null) {
			logger.error("Field is null.");
			return new ResponseEntity<Field>(HttpStatus.BAD_REQUEST);
		}
		
		Field field2 = fService.save(field);
		
		if(field2 == null) {
			logger.error("Field is null.");
			return new ResponseEntity<Field>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Field>(field2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Field> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Field>(HttpStatus.BAD_REQUEST);
		}
		
		Field field = fService.findOne(id);
		
		if(field == null) {
			logger.error("Field doesn't exist.");
			return new ResponseEntity<Field>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Field>(field, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Field> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Field>(HttpStatus.BAD_REQUEST);
		}
		
		Field field = fService.findOne(id);
		
		if(field == null) {
			logger.error("Field doesn't exist.");
			return new ResponseEntity<Field>(HttpStatus.NOT_FOUND);
		}
		
		fService.delete(id);
		return new ResponseEntity<Field>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Field> deleteAll(){
		fService.deleteAll();
		return new ResponseEntity<Field>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/fields", method = RequestMethod.GET)
	public ResponseEntity<List<Field>> getFields(){
		return new ResponseEntity<List<Field>>(fService.getListOfFields(MappingType.CLIENT), HttpStatus.OK);
	}
}
