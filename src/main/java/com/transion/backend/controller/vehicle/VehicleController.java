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

import com.transion.backend.model.vehicle.Vehicle;
import com.transion.backend.service.vehicle.VehicleService;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

	@Autowired
	VehicleService vService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> getAll(){
		return new ResponseEntity<List<Vehicle>>(vService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle){
		if(vehicle == null) {
			logger.error("Vehicle is null.");
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		
		Vehicle vehicle2 = vService.save(vehicle);
		
		if(vehicle2 == null) {
			logger.error("Vehicle is null.");
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Vehicle>(vehicle2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		
		Vehicle vehicle = vService.findOne(id);
		
		if(vehicle == null) {
			logger.error("Vehicle doesn't exist.");
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Vehicle> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		
		Vehicle vehicle = vService.findOne(id);
		
		if(vehicle == null) {
			logger.error("Vehicle doesn't exist.");
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		
		vService.delete(id);
		return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Vehicle> deleteAll(){
		vService.deleteAll();
		return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}
}
