package com.transion.backend.model.chartofaccounts;

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
@Table(name = "CHARTOFACCOUNTS")
public class ChartOfAccounts implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "VALIDITYFROM")
	private Date validityFrom;
	
	@OneToMany
	@JoinColumn(name = "CHARTOFACCOUNT_ID", referencedColumnName = "id")
	private List<ChartOfAccountsClass> classes = new ArrayList<ChartOfAccountsClass>();
	
	@Column(name = "DESCRIPTION")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getValidityFrom() {
		return validityFrom;
	}

	public void setValidityFrom(Date validityFrom) {
		this.validityFrom = validityFrom;
	}

	public List<ChartOfAccountsClass> getClasses() {
		return classes;
	}

	public void setClasses(List<ChartOfAccountsClass> classes) {
		this.classes = classes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
