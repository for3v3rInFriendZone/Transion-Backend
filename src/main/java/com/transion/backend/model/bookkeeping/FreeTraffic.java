package com.transion.backend.model.bookkeeping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FREETRAFIC")
public class FreeTraffic implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "RIGHTTODEDUCTION")
	private Double rightToDeduction;
	
	@Column(name = "WITHOUTRIGHTTODEDUCTION")
	private Double withoutRightToDeduction;
	
	@Column(name = "FOREINGRIGHTDEDUCT")
	private Double foreingRightDeduct;
	
	@Column(name = "FOREINGWITHOUTDEDUCTION")
	private Double foreingWithoutDeduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRightToDeduction() {
		return rightToDeduction;
	}

	public void setRightToDeduction(Double rightToDeduction) {
		this.rightToDeduction = rightToDeduction;
	}

	public Double getWithoutRightToDeduction() {
		return withoutRightToDeduction;
	}

	public void setWithoutRightToDeduction(Double withoutRightToDeduction) {
		this.withoutRightToDeduction = withoutRightToDeduction;
	}

	public Double getForeingRightDeduct() {
		return foreingRightDeduct;
	}

	public void setForeingRightDeduct(Double foreingRightDeduct) {
		this.foreingRightDeduct = foreingRightDeduct;
	}

	public Double getForeingWithoutDeduct() {
		return foreingWithoutDeduct;
	}

	public void setForeingWithoutDeduct(Double foreingWithoutDeduct) {
		this.foreingWithoutDeduct = foreingWithoutDeduct;
	}
}
