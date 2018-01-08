package com.transion.backend.model.bookkeeping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHANGEORDER")
public class ChangeOrder implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CREATEDON")
	private Date createdOn;
	
	@Column(name = "SERIALNUMBER")
	private String serialNumber;
	
	@OneToMany
	@JoinColumn(name = "CHANGEORDER_ID", referencedColumnName = "id")
	private List<Change> changes = new ArrayList<Change>();
	
	@Column(name = "OWINGSALDO")
	private Double owingSaldo;
	
	@Column(name = "LOOKINGSALDO")
	private Double lookingSaldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public List<Change> getChanges() {
		return changes;
	}

	public void setChanges(List<Change> changes) {
		this.changes = changes;
	}

	public Double getOwingSaldo() {
		return owingSaldo;
	}

	public void setOwingSaldo(Double owingSaldo) {
		this.owingSaldo = owingSaldo;
	}

	public Double getLookingSaldo() {
		return lookingSaldo;
	}

	public void setLookingSaldo(Double lookingSaldo) {
		this.lookingSaldo = lookingSaldo;
	}
}
