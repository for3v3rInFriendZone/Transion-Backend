package com.transion.backend.controller.vehicle;

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

import com.transion.backend.model.vehicle.Brand;
import com.transion.backend.service.vehicle.BrandService;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {
	
	@Autowired
	BrandService bService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Brand>> getAll(){
		return new ResponseEntity<List<Brand>>(bService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Brand> save(@RequestBody Brand brand){
		if(brand == null) {
			logger.error("Brand is null.");
			return new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
		}
		
		Brand brand2 = bService.save(brand);
		
		if(brand2 == null) {
			logger.error("Brand is null.");
			return new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Brand>(brand2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Brand> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
		}
		
		Brand brand = bService.findOne(id);
		
		if(brand == null) {
			logger.error("Brand doesn't exist.");
			return new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Brand>(brand, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Brand> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
		}
		
		Brand brand = bService.findOne(id);
		
		if(brand == null) {
			logger.error("Brand doesn't exist.");
			return new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
		}
		
		bService.delete(id);
		return new ResponseEntity<Brand>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE) 
	public ResponseEntity<Brand> deleteAll(){
		bService.deleteAll();
		return new ResponseEntity<Brand>(HttpStatus.OK);
	}
}
