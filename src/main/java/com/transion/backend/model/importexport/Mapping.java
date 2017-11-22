package com.transion.backend.model.importexport;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAPPING")
public class Mapping implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "MAP_TYPE")
	private MappingType type;
	
	@Column(name = "LABEL")
	private String label;
	
	public enum MappingType {
		CLIENT("CLIENT"),
		TRANSACTION("TRANSACTION");
		
		private String name;
		
		private MappingType(String name) {
			this.name = name;
		}
	}
	
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
