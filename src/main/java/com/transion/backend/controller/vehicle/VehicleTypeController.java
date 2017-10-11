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

import com.transion.backend.model.vehicle.VehicleType;
import com.transion.backend.service.vehicle.VehicleTypeService;

@RestController
@RequestMapping(value = "vehicletype")
public class VehicleTypeController {
	
	@Autowired
	VehicleTypeService vtService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VehicleType>> getAll(){
		return new ResponseEntity<List<VehicleType>>(vtService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<VehicleType> save(@RequestBody VehicleType vehicleType){
		if(vehicleType == null) {
			logger.error("Vehicle is null.");
			return new ResponseEntity<VehicleType>(HttpStatus.BAD_REQUEST);
		}
		
		VehicleType vehicleType2 = vtService.save(vehicleType);
		
		if(vehicleType2 == null) {
			logger.error("VehicleType is null.");
			return new ResponseEntity<VehicleType>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<VehicleType>(vehicleType2, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VehicleType> findOne(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<VehicleType>(HttpStatus.BAD_REQUEST);
		}
		
		VehicleType vehicleType = vtService.findOne(id);
		
		if(vehicleType == null) {
			logger.error("VehicleType doesn't exist.");
			return new ResponseEntity<VehicleType>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<VehicleType>(vehicleType, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<VehicleType> delete(@PathVariable Long id){
		if(id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<VehicleType>(HttpStatus.BAD_REQUEST);
		}
		
		VehicleType vehicleType = vtService.findOne(id);
		
		if(vehicleType == null) {
			logger.error("VehicleType doesn't exist.");
			return new ResponseEntity<VehicleType>(HttpStatus.BAD_REQUEST);
		}
		
		vtService.delete(id);
		return new ResponseEntity<VehicleType>(HttpStatus.OK);
	}
	
	public ResponseEntity<VehicleType> deleteAll(){
		vtService.deleteAll();
		return new ResponseEntity<VehicleType>(HttpStatus.OK);
	}
}
