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

import com.transion.backend.model.importexport.ImportLine;
import com.transion.backend.service.importexport.ImportLineService;

@RestController
@RequestMapping(value = "/importline")
public class ImportLineController {
	
	@Autowired
	ImportLineService ilService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ImportLine>> getAll(){
		return new ResponseEntity<List<ImportLine>>(ilService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ImportLine> save(@RequestBody ImportLine importLine) {
		if(importLine == null) {
			logger.error("ImportLine is null.");
			return new ResponseEntity<ImportLine>(HttpStatus.BAD_REQUEST);
		}
		
		ImportLine importLine2 = ilService.save(importLine);
		
		if(importLine2 == null) {
			logger.error("ImportLine is null.");
			return new ResponseEntity<ImportLine>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ImportLine>(importLine2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ImportLine> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ImportLine>(HttpStatus.BAD_REQUEST);
		}
		
		ImportLine importLine = ilService.findOne(id);
		
		if(importLine == null) {
			logger.error("ImportLine doesn't exist.");
			return new ResponseEntity<ImportLine>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ImportLine>(importLine, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<ImportLine> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ImportLine>(HttpStatus.BAD_REQUEST);
		}
		
		ImportLine importLine = ilService.findOne(id);
		
		if(importLine == null) {
			logger.error("ImportLine doesn't exist.");
			return new ResponseEntity<ImportLine>(HttpStatus.BAD_REQUEST);
		}
		
		ilService.delete(id);
		return new ResponseEntity<ImportLine>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<ImportLine> deleteAll(){
		ilService.deleteAll();
		return new ResponseEntity<ImportLine>(HttpStatus.OK);
	}
}
