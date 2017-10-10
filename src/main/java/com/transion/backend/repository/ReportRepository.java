package com.transion.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long>{

}
