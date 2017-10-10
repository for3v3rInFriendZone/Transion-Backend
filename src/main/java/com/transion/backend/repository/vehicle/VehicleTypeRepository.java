package com.transion.backend.repository.vehicle;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.vehicle.VehicleType;

@Repository
public interface VehicleTypeRepository extends CrudRepository<VehicleType, Long>{

}
