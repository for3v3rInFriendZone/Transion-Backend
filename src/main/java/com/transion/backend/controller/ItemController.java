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

import com.transion.backend.model.Item;
import com.transion.backend.service.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
	
	@Autowired
	ItemService iService;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Item>> getAll(){
		return new ResponseEntity<List<Item>>(iService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Item> save(@RequestBody Item item){
		if(item == null) {
			logger.error("Item is null.");
			return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
		}
		
		Item item2 = iService.save(item);
		
		if(item2 == null) {
			logger.error("Item is null.");
			return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Item>(item2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
		}
		
		Item item = iService.findOne(id);
		
		if(item == null) {
			logger.error("Item doesn't exist.");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Item> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
		}
		
		Item item = iService.findOne(id);
		
		if(item == null) {
			logger.error("Item doesn't exist.");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		
		iService.delete(id);
		return new ResponseEntity<Item>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Item> deleteAll(){
		iService.deleteAll();
		return new ResponseEntity<Item>(HttpStatus.OK);
	}
}
