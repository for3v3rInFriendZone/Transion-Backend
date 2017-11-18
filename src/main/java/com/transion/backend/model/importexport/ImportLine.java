package com.transion.backend.model.importexport;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IMPORTLINE")
public class ImportLine implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "REF_ID", nullable = false)
	private Long refId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAPPING_ID", nullable = false)
	private Mapping mapping;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRefId() {
		return refId;
	}

	public void setRefId(Long refId) {
		this.refId = refId;
	}

	public Mapping getMapping() {
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

	public ImportLine(Long refId, Mapping mapping) {
		super();
		this.refId = refId;
		this.mapping = mapping;
	}

	public ImportLine() {
		super();
	}
}
