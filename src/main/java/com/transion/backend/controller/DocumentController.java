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

import com.transion.backend.model.Document;
import com.transion.backend.service.DocumentService;

@RestController
@RequestMapping(value = "/document")
public class DocumentController {

	@Autowired
	DocumentService dService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Document>> getAll(){
		return new ResponseEntity<List<Document>>(dService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Document> save(@RequestBody Document document){
		if(document == null) {
			logger.error("Document is null.");
			return new ResponseEntity<Document>(HttpStatus.BAD_REQUEST);
		}
		
		Document document2 = dService.save(document);
		
		if(document2 == null) {
			logger.error("Document is null.");
			return new ResponseEntity<Document>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Document>(document2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Document> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Document>(HttpStatus.BAD_REQUEST);
		}
		
		Document document = dService.findOne(id);
		
		if(document == null) {
			logger.error("Document doesn't exist.");
			return new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Document>(document, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Document> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Document>(HttpStatus.BAD_REQUEST);
		}
		
		Document document = dService.findOne(id);
		
		if(document == null) {
			logger.error("Document doesn't exist.");
			return new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
		}
		
		dService.delete(id);
		return new ResponseEntity<Document>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Document> deleteAll(){
		dService.deleteAll();
		return new ResponseEntity<Document>(HttpStatus.OK);
	}
}
