package com.transion.backend.controller.chartofaccounts;

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

import com.transion.backend.model.chartofaccounts.ChartOfAccounts;
import com.transion.backend.service.chartofaccounts.ChartOfAccountsService;

@RestController
@RequestMapping(value = "/chartofaccounts")
public class ChartOfAccountsController {

	@Autowired
	ChartOfAccountsService coas;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ChartOfAccounts>> getAll(){
		return new ResponseEntity<List<ChartOfAccounts>>(coas.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ChartOfAccounts> save(@RequestBody ChartOfAccounts konto){
		if(konto == null) {
			logger.error("konto is null.");
			return new ResponseEntity<ChartOfAccounts>(HttpStatus.BAD_REQUEST);
		}
		
		ChartOfAccounts konto2 = coas.save(konto);
		
		if(konto2 == null) {
			logger.error("konto is null.");
			return new ResponseEntity<ChartOfAccounts>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ChartOfAccounts>(konto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ChartOfAccounts> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ChartOfAccounts>(HttpStatus.BAD_REQUEST);
		}
		
		ChartOfAccounts konto= coas.findOne(id);
		
		if(konto == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<ChartOfAccounts>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ChartOfAccounts>(konto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<ChartOfAccounts> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ChartOfAccounts>(HttpStatus.BAD_REQUEST);
		}
		
		ChartOfAccounts konto = coas.findOne(id);
		
		if(konto == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<ChartOfAccounts>(HttpStatus.NOT_FOUND);
		}
		
		coas.delete(id);
		return new ResponseEntity<ChartOfAccounts>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<ChartOfAccounts> deleteAll(){
		coas.deleteAll();
		return new ResponseEntity<ChartOfAccounts>(HttpStatus.OK);
	}
}
