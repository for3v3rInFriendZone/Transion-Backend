package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.transion.backend.model.Measure;

@Repository
public interface MeasureRepository extends CrudRepository<Measure, Long>{

}
