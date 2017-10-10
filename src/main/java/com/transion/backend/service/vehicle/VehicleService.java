package com.transion.backend.service.vehicle;

import java.util.List;

import com.transion.backend.model.vehicle.Vehicle;

public interface VehicleService {

	public Vehicle save(Vehicle vehicle);
	
	public List<Vehicle> save(List<Vehicle> vehicles);
	
	public Vehicle findOne(Long id);
	
	public List<Vehicle> findAll();
	
	public void delete(Long id);
	
	public void delete(Vehicle vehicle);
	
	public void deleteAll();
	
	public void deleteAll(List<Vehicle> vehicles);
}
