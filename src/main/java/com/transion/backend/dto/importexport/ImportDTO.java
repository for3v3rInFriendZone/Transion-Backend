package com.transion.backend.dto.importexport;

import java.util.ArrayList;
import java.util.List;

public class ImportDTO {

	private Long id;
	private List<ImportLineDTO> importLines = new ArrayList<ImportLineDTO>();
	private MappingDTO mapping;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ImportLineDTO> getImportLines() {
		return importLines;
	}

	public void setImportLines(List<ImportLineDTO> importLines) {
		this.importLines = importLines;
	}

	public MappingDTO getMapping() {
		return mapping;
	}

	public void setMapping(MappingDTO mapping) {
		this.mapping = mapping;
	}

}
