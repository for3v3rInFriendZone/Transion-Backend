package com.transion.backend.service.vehicle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.vehicle.Vehicle;
import com.transion.backend.repository.vehicle.VehicleRepository;
import com.transion.backend.service.vehicle.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> save(List<Vehicle> vehicles) {
		return (List<Vehicle>) vehicleRepository.save(vehicles);
	}

	@Override
	public Vehicle findOne(Long id) {
		return vehicleRepository.findOne(id);
	}

	@Override
	public List<Vehicle> findAll() {
		return (List<Vehicle>) vehicleRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		vehicleRepository.delete(id);
	}

	@Override
	public void delete(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}

	@Override
	public void deleteAll() {
		vehicleRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Vehicle> vehicles) {
		vehicleRepository.delete(vehicles);
	}

}
