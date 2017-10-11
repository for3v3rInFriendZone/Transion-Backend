package com.transion.backend.dto.importexport;

import java.util.ArrayList;
import java.util.List;
import com.transion.backend.model.importexport.ExportLine;
import com.transion.backend.model.importexport.Mapping;

public class ExportDTO {

	private Long id;
	private List<ExportLine> exportLines = new ArrayList<ExportLine>();
	private Mapping mapping;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ExportLine> getExportLines() {
		return exportLines;
	}

	public void setExportLines(List<ExportLine> exportLines) {
		this.exportLines = exportLines;
	}

	public Mapping getMapping() {
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

}
