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

import com.transion.backend.model.Report;
import com.transion.backend.service.ReportService;

@RestController
@RequestMapping(value = "/report")
public class ReportController {

	@Autowired
	ReportService rService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Report>> getAll(){
		return new ResponseEntity<List<Report>>(rService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Report> save(@RequestBody Report report){
		if(report == null) {
			logger.error("Report is null.");
			return new ResponseEntity<Report>(HttpStatus.BAD_REQUEST);
		}
		
		Report report2 = rService.save(report);
		
		if(report2 == null) {
			logger.error("Report is null.");
			return new ResponseEntity<Report>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Report>(report2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Report> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Report>(HttpStatus.BAD_REQUEST);
		}
		
		Report report = rService.findOne(id);
		
		if(report == null) {
			logger.error("Report doesn't exist.");
			return new ResponseEntity<Report>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Report> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Report>(HttpStatus.BAD_REQUEST);
		}
		
		Report report = rService.findOne(id);
		
		if(report == null) {
			logger.error("Report doesn't exist.");
			return new ResponseEntity<Report>(HttpStatus.NOT_FOUND);
		}
		
		rService.delete(id);
		return new ResponseEntity<Report>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Report> deleteAll(){
		rService.deleteAll();
		return new ResponseEntity<Report>(HttpStatus.OK);
	}
}
