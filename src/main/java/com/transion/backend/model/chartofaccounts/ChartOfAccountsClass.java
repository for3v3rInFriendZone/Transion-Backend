package com.transion.backend.model.chartofaccounts;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "CHARTOFACCOUNTSCLASS")
public class ChartOfAccountsClass implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "id")
	private List<ChartOfAccountsOrder> orders = new ArrayList<ChartOfAccountsOrder>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ChartOfAccountsOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ChartOfAccountsOrder> orders) {
		this.orders = orders;
	}
}
