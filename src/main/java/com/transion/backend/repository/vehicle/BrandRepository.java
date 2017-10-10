package com.transion.backend.repository.vehicle;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.vehicle.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long>{

}
