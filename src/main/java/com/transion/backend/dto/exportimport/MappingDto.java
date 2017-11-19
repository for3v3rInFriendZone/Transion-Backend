package com.transion.backend.dto.exportimport;

import java.util.ArrayList;
import java.util.List;
import com.transion.backend.model.importexport.Field;
import com.transion.backend.model.importexport.Mapping.MappingType;

public class MappingDto {

	private Long id;
	private MappingType type;
	private List<Field> fields = new ArrayList<Field>();
	private String label;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MappingType getType() {
		return type;
	}
	public void setType(MappingType type) {
		this.type = type;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
