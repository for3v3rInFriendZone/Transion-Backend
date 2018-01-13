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

import com.transion.backend.model.bookkeeping.MainBook;
import com.transion.backend.service.bookkeeping.MainBookService;


@RestController
@RequestMapping(value = "/mainbook")
public class MainBookController {

	@Autowired
	MainBookService mbs;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MainBook>> getAll(){
		return new ResponseEntity<List<MainBook>>(mbs.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MainBook> save(@RequestBody MainBook mainBook){
		if(mainBook == null) {
			logger.error("mainBook is null.");
			return new ResponseEntity<MainBook>(HttpStatus.BAD_REQUEST);
		}
		
		MainBook mainBook2 = mbs.save(mainBook);
		
		if(mainBook2 == null) {
			logger.error("mainBook is null.");
			return new ResponseEntity<MainBook>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<MainBook>(mainBook, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MainBook> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<MainBook>(HttpStatus.BAD_REQUEST);
		}
		
		MainBook mainBook= mbs.findOne(id);
		
		if(mainBook == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<MainBook>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<MainBook>(mainBook, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<MainBook> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<MainBook>(HttpStatus.BAD_REQUEST);
		}
		
		MainBook mainBook = mbs.findOne(id);
		
		if(mainBook == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<MainBook>(HttpStatus.NOT_FOUND);
		}
		
		mbs.delete(id);
		return new ResponseEntity<MainBook>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<MainBook> deleteAll(){
		mbs.deleteAll();
		return new ResponseEntity<MainBook>(HttpStatus.OK);
	}
}
