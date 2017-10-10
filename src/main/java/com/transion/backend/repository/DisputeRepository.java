package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Dispute;

@Repository
public interface DisputeRepository extends CrudRepository<Dispute, Long>{

}
