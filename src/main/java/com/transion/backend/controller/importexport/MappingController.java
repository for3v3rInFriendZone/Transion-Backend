package com.transion.backend.controller.importexport;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.transion.backend.dto.exportimport.MappingDTO;
import com.transion.backend.model.importexport.Mapping;
import com.transion.backend.model.importexport.Mapping.MappingType;
import com.transion.backend.service.importexport.FieldService;
import com.transion.backend.service.importexport.MappingService;

@RestController
@RequestMapping(value = "/mapping")
public class MappingController {

	@Autowired
	MappingService mService;

	@Autowired
	FieldService fieldSer;

	@Autowired
	ModelMapper modelMap;

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MappingDTO>> getAll() {

		List<MappingDTO> mappingsDTO = new ArrayList<MappingDTO>();
		List<Mapping> mappings = mService.findAll();
		for (Mapping m : mappings) {
			MappingDTO mappingDTO = modelMap.map(m, MappingDTO.class);
			mappingDTO.setFields(fieldSer.findByMapping(m));
			mappingsDTO.add(mappingDTO);
		}
		return new ResponseEntity<List<MappingDTO>>(mappingsDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Mapping> save(@RequestBody MappingDTO mappingDto) {
		if (mappingDto == null) {
			logger.error("Mapping is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}

		Mapping mapping2 = mService.save(mappingDto);

		if (mapping2 == null) {
			logger.error("Mapping is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Mapping>(mapping2, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Mapping> update(@RequestBody MappingDTO mappingDto) {
		if (mappingDto == null) {
			logger.error("Mapping is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}

		Mapping mapping2 = mService.update(mappingDto);

		if (mapping2 == null) {
			logger.error("Mapping is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Mapping>(mapping2, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mapping> findOne(@PathVariable Long id) {
		if (id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}

		Mapping mapping = mService.findOne(id);

		if (mapping == null) {
			logger.error("Mapping doesn't exist.");
			return new ResponseEntity<Mapping>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Mapping>(mapping, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mapping> delete(@PathVariable Long id) {
		if (id == null) {
			logger.error("Id is null.");
			return new ResponseEntity<Mapping>(HttpStatus.BAD_REQUEST);
		}

		Mapping mapping = mService.findOne(id);

		if (mapping == null) {
			logger.error("Mapping doesn't exist.");
			return new ResponseEntity<Mapping>(HttpStatus.NOT_FOUND);
		}

		mService.delete(id);
		return new ResponseEntity<Mapping>(new Mapping(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Mapping> deleteAll() {
		mService.deleteAll();
		return new ResponseEntity<Mapping>(new Mapping(), HttpStatus.OK);
	}

	@RequestMapping(value = "/checkMapping", method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkIfMappingExists(@RequestParam(value = "type") MappingType type) {
		if (type == null) {
			logger.error("Type is null.");
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		List<Mapping> mapping = mService.findAll();

		for (Mapping m : mapping) {
			if (m.getType().equals(type)) {
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}
		}

		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
}
