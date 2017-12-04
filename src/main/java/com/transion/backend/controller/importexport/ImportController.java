package com.transion.backend.controller.importexport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.transion.backend.model.importexport.Import;
import com.transion.backend.model.importexport.Mapping;
import com.transion.backend.service.importexport.ImportService;
import com.transion.backend.service.importexport.MappingService;

@RestController
@RequestMapping(value = "/import")
public class ImportController {
	
	@Autowired
	ImportService iService;
	
	@Autowired
	MappingService mappingSer;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Import>> getAll(){
		return new ResponseEntity<List<Import>>(iService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Import> save(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "mapping") String mapping) throws IOException, InterruptedException, ParseException{
		if(file == null) {
			logger.error("Import is null.");
			return new ResponseEntity<Import>(HttpStatus.BAD_REQUEST);
		}
		
		if(mapping == null || mapping.equals("")) {
			logger.error("Mapping is null.");
			return new ResponseEntity<Import>(HttpStatus.BAD_REQUEST);
		}
		
		Mapping map = mappingSer.findOne(Long.parseLong(mapping));
		Import i = iService.importData(file, map);
		
		return new ResponseEntity<Import>(iService.save(i), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Import> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Import>(HttpStatus.BAD_REQUEST);
		}
		
		Import import1 = iService.findOne(id);
		
		if(import1 == null) {
			logger.error("Import doesn't exist.");
			return new ResponseEntity<Import>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Import>(import1, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Import> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Import>(HttpStatus.BAD_REQUEST);
		}
		
		Import import1 = iService.findOne(id);
		
		if(import1 == null) {
			logger.error("Import doesn't exist.");
			return new ResponseEntity<Import>(HttpStatus.NOT_FOUND);
		}
		
		iService.delete(id);
		return new ResponseEntity<Import>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Import> deleteAll(){
		iService.deleteAll();
		return new ResponseEntity<Import>(HttpStatus.OK);
	}
}
