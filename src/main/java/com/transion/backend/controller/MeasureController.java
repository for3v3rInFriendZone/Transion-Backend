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

import com.transion.backend.model.Measure;
import com.transion.backend.model.Tax;
import com.transion.backend.service.MeasureService;
import com.transion.backend.service.TaxService;

@RestController
@RequestMapping(value = "/measure")
public class MeasureController {

	@Autowired
	MeasureService meaService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Measure>> getAll(){
		return new ResponseEntity<List<Measure>>(meaService.findAll(), HttpStatus.OK);
	}
	
}
