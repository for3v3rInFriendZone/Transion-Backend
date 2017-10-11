package com.transion.backend.dto.importexport;

import java.util.ArrayList;
import java.util.List;

public class MappingDTO {

	private Long id;
	private List<FieldDTO> fields = new ArrayList<FieldDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FieldDTO> getFields() {
		return fields;
	}

	public void setFields(List<FieldDTO> fields) {
		this.fields = fields;
	}

}
