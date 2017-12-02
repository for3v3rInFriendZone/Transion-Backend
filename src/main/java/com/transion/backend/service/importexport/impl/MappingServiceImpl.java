package com.transion.backend.service.importexport.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transion.backend.dto.exportimport.MappingDTO;
import com.transion.backend.model.importexport.Field;
import com.transion.backend.model.importexport.Mapping;
import com.transion.backend.repository.importexport.MappingRepository;
import com.transion.backend.service.importexport.FieldService;
import com.transion.backend.service.importexport.MappingService;

@Service
public class MappingServiceImpl implements MappingService {

	@Autowired
	MappingRepository mappingRepository;

	@Autowired
	FieldService fService;

	@Autowired
	ModelMapper modelMap;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Mapping update(MappingDTO mappingDto) {
		Mapping m = modelMap.map(mappingDto, Mapping.class);

		List<Field> allFields = fService.findAll();

		// ovde radimo razvezivanje stranih kljuceva ili setovanje istih.
		for (Field f : allFields) {
			if (!mappingDto.getFields().contains(f) && f.getImportEnum().toString().startsWith(m.getType().name())) {
				f.setMapping(null);
			} else if (f.getMapping() == null && f.getImportEnum().toString().startsWith(m.getType().name())) {
				f.setMapping(m);
			}
		}

		return mappingRepository.save(m);

	}

	@Override
	public Mapping save(MappingDTO mappingDto) {
		Mapping m = modelMap.map(mappingDto, Mapping.class);

		List<Field> allFields = fService.findAll();

		for (Field f : allFields) {
			if (mappingDto.getFields().contains(f)) {
				f.setMapping(m);
			}
		}

		return mappingRepository.save(m);
	}

	@Override
	public List<Mapping> save(List<Mapping> mappings) {
		return (List<Mapping>) mappingRepository.save(mappings);
	}

	@Override
	public Mapping findOne(Long id) {
		return mappingRepository.findOne(id);
	}

	@Override
	public List<Mapping> findAll() {
		return (List<Mapping>) mappingRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		List<Field> fields = em.createNativeQuery("SELECT * FROM FIELD WHERE MAPPING_ID = ?1", Field.class)
				.setParameter(1, id).getResultList();
		for (Field f : fields) {
			f.setMapping(null);
		}
		mappingRepository.delete(id);
	}

	@Override
	public void delete(Mapping mapping) {
		mappingRepository.delete(mapping);
	}

	@Override
	public void deleteAll() {
		mappingRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Mapping> mappings) {
		mappingRepository.delete(mappings);
	}

}
