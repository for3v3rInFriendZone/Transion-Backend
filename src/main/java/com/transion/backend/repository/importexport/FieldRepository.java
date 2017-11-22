package com.transion.backend.repository.importexport;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.importexport.Field;
import com.transion.backend.model.importexport.Mapping;

@Repository
public interface FieldRepository extends CrudRepository<Field, Long>{

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE field SET mapping_id = ?1 WHERE id = ?2", nativeQuery = true)
	public void updateMapping(Long mappingId, Long fieldId);
	
	public List<Field> findByMapping(Mapping mapping);
	
	public List<Field> findByRequired(Boolean required);
}
