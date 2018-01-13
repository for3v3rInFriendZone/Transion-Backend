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

import com.transion.backend.model.bookkeeping.ChangeOrder;
import com.transion.backend.service.bookkeeping.ChangeOrderService;

@RestController
@RequestMapping(value = "/changeorder")
public class ChangeOrderController {

	@Autowired
	ChangeOrderService cos;

	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ChangeOrder>> getAll(){
		return new ResponseEntity<List<ChangeOrder>>(cos.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ChangeOrder> save(@RequestBody ChangeOrder changeOrder){
		if(changeOrder == null) {
			logger.error("changeOrder is null.");
			return new ResponseEntity<ChangeOrder>(HttpStatus.BAD_REQUEST);
		}
		
		ChangeOrder changeOrder2 = cos.save(changeOrder);
		
		if(changeOrder2 == null) {
			logger.error("changeOrder is null.");
			return new ResponseEntity<ChangeOrder>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ChangeOrder>(changeOrder, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ChangeOrder> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ChangeOrder>(HttpStatus.BAD_REQUEST);
		}
		
		ChangeOrder changeOrder= cos.findOne(id);
		
		if(changeOrder == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<ChangeOrder>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ChangeOrder>(changeOrder, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<ChangeOrder> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<ChangeOrder>(HttpStatus.BAD_REQUEST);
		}
		
		ChangeOrder changeOrder = cos.findOne(id);
		
		if(changeOrder == null) {
			logger.error("Address doesn't exist.");
			return new ResponseEntity<ChangeOrder>(HttpStatus.NOT_FOUND);
		}
		
		cos.delete(id);
		return new ResponseEntity<ChangeOrder>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<ChangeOrder> deleteAll(){
		cos.deleteAll();
		return new ResponseEntity<ChangeOrder>(HttpStatus.OK);
	}
}
