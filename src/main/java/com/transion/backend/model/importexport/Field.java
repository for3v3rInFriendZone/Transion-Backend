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

import com.transion.backend.util.ImportEnum;

@Entity
@Table(name = "FIELD")
public class Field implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "IS_REQUIRED")
	private boolean required;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAPPING_ID", nullable = false)
	private Mapping mapping;

	@Column(name = "IMPORT_ENUM")
	private ImportEnum importEnum;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public Mapping getMapping() {
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

	public ImportEnum getImportEnum() {
		return importEnum;
	}

	public void setImportEnum(ImportEnum importEnum) {
		this.importEnum = importEnum;
	}

	public Field() {
		super();
	}

	public Field(String name, String type, boolean required, ImportEnum importEnum) {
		super();
		this.name = name;
		this.type = type;
		this.required = required;
		this.importEnum = importEnum;
	}
	
}
