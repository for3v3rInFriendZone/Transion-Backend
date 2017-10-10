package com.transion.backend.repository.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.address.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

}
