package com.transion.backend.service.vehicle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transion.backend.model.vehicle.VehicleType;
import com.transion.backend.repository.vehicle.VehicleTypeRepository;
import com.transion.backend.service.vehicle.VehicleTypeService;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService{

	@Autowired
	VehicleTypeRepository vtRepository;
	
	@Override
	public VehicleType save(VehicleType vehicleType) {
		return vtRepository.save(vehicleType);
	}

	@Override
	public List<VehicleType> save(List<VehicleType> vehicleTypes) {
		return (List<VehicleType>) vtRepository.save(vehicleTypes);
	}

	@Override
	public VehicleType findOne(Long id) {
		return vtRepository.findOne(id);
	}

	@Override
	public List<VehicleType> findAll() {
		return (List<VehicleType>) vtRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		vtRepository.delete(id);
	}

	@Override
	public void delete(VehicleType vehicleType) {
		vtRepository.delete(vehicleType);
	}

	@Override
	public void deleteAll() {
		vtRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<VehicleType> vehicleTypes) {
		vtRepository.delete(vehicleTypes);
	}

}
