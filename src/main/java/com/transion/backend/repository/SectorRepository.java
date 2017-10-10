package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Sector;

@Repository
public interface SectorRepository extends CrudRepository<Sector, Long>{

}
