package com.transion.backend.controller.bookkeeping;

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

import com.transion.backend.model.bookkeeping.AccountingDiary;
import com.transion.backend.service.bookkeeping.AccountingDiaryService;

@RestController
@RequestMapping(value = "/accountingdiary")
public class AccountingDiaryController {

	@Autowired
	AccountingDiaryService ads;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AccountingDiary>> getAll(){
		return new ResponseEntity<List<AccountingDiary>>(ads.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountingDiary> save(@RequestBody AccountingDiary diary){
		if(diary == null) {
			logger.error("Diary is null.");
			return new ResponseEntity<AccountingDiary>(HttpStatus.BAD_REQUEST);
		}
		
		AccountingDiary diary2 = ads.save(diary);
		
		if(diary2 == null) {
			logger.error("Diary is null.");
			return new ResponseEntity<AccountingDiary>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<AccountingDiary>(diary, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AccountingDiary> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<AccountingDiary>(HttpStatus.BAD_REQUEST);
		}
		
		AccountingDiary diary= ads.findOne(id);
		
		if(diary == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<AccountingDiary>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AccountingDiary>(diary, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<AccountingDiary> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<AccountingDiary>(HttpStatus.BAD_REQUEST);
		}
		
		AccountingDiary diary = ads.findOne(id);
		
		if(diary == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<AccountingDiary>(HttpStatus.NOT_FOUND);
		}
		
		ads.delete(id);
		return new ResponseEntity<AccountingDiary>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<AccountingDiary> deleteAll(){
		ads.deleteAll();
		return new ResponseEntity<AccountingDiary>(HttpStatus.OK);
	}
}
