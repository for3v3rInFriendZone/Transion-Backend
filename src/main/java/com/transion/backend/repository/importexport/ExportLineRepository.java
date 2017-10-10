package com.transion.backend.repository.importexport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.importexport.ExportLine;

@Repository
public interface ExportLineRepository extends CrudRepository<ExportLine, Long>{

}
