package com.transion.backend.model.importexport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EXPORT")
public class Export implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "EXPORT_ID", referencedColumnName = "id")
	private List<ExportLine> exportLines = new ArrayList<ExportLine>();
	
	@ManyToOne
	@JoinColumn(name = "MAPPING_ID")
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
