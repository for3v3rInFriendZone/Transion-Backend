package com.transion.backend.service.vehicle;

import java.util.List;

import com.transion.backend.model.vehicle.VehicleType;

public interface VehicleTypeService {
	
	public VehicleType save(VehicleType vehicleType);
	
	public List<VehicleType> save(List<VehicleType> vehicleTypes);
	
	public VehicleType findOne(Long id);
	
	public List<VehicleType> findAll();
	
	public void delete(Long id);
	
	public void delete(VehicleType vehicleType);
	
	public void deleteAll();
	
	public void deleteAll(List<VehicleType> vehicleTypes);
}
