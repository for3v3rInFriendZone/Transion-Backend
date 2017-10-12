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

import com.transion.backend.model.importexport.ExportLine;
import com.transion.backend.service.importexport.ExportLineService;

@RestController
@RequestMapping(value = "/exportline")
public class ExportLineController {
	
	@Autowired
	ExportLineService elService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExportLine>> getAll(){
		return new ResponseEntity<List<ExportLine>>(elService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ExportLine> save(@RequestBody ExportLine exportLine){
		if(exportLine == null) {
			logger.error("ExportLine is null.");
			return new ResponseEntity<ExportLine>(HttpStatus.BAD_REQUEST);
		}
		
		ExportLine exportLine2 = elService.save(exportLine);
		
		if(exportLine2 == null) {
			logger.error("ExportLine is null.");
			return new ResponseEntity<ExportLine>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ExportLine>(exportLine2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExportLine> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ExportLine>(HttpStatus.BAD_REQUEST);
		}
		
		ExportLine exportLine = elService.findOne(id);
		
		if(exportLine == null) {
			logger.error("ExportLine doesn't exist.");
			return new ResponseEntity<ExportLine>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ExportLine>(exportLine, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<ExportLine> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ExportLine>(HttpStatus.BAD_REQUEST);
		}
		
		ExportLine exportLine = elService.findOne(id);
		
		if(exportLine == null) {
			logger.error("ExportLine doesn't exist.");
			return new ResponseEntity<ExportLine>(HttpStatus.NOT_FOUND);
		}
		
		elService.delete(id);
		return new ResponseEntity<ExportLine>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<ExportLine> deleteAll(){
		elService.deleteAll();
		return new ResponseEntity<ExportLine>(HttpStatus.OK);
	}
}
