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

import com.transion.backend.model.importexport.Export;
import com.transion.backend.service.importexport.ExportService;

@RestController
@RequestMapping(value = "/export")
public class ExportController {

	@Autowired
	ExportService eService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Export>> getAll(){
		return new ResponseEntity<List<Export>>(eService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Export> save(@RequestBody Export export){
		if(export == null) {
			logger.error("Export is null.");
			return new ResponseEntity<Export>(HttpStatus.BAD_REQUEST);
		}
		
		Export export2 = eService.save(export);
		
		if(export2 == null) {
			logger.error("Export is null.");
			return new ResponseEntity<Export>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Export>(export2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Export> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Export>(HttpStatus.BAD_REQUEST);
		}
		
		Export export = eService.findOne(id);
		
		if(export == null) {
			logger.error("Export doesn't exist.");
			return new ResponseEntity<Export>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Export>(export, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Export> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Export>(HttpStatus.BAD_REQUEST);
		}
		
		Export export = eService.findOne(id);
		
		if(export == null) {
			logger.error("Export doesn't exist.");
			return new ResponseEntity<Export>(HttpStatus.NOT_FOUND);
		}
		
		eService.delete(id);
		return new ResponseEntity<Export>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Export> deleteAll(){
		eService.deleteAll();
		return new ResponseEntity<Export>(HttpStatus.OK);
	}
}
