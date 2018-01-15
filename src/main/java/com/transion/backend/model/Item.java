package com.transion.backend.model;

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
@Table(name = "ITEM")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "EXTERNALKEY", nullable = false, unique = true)
	private String externalUniqueKey;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PURCHESEPRICE")
	private Double purchesePrice;
	
	@Column(name = "SELLINGPRICE")	
	private Double sellingPrice;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MEASURE_ID")
	private Measure measure;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TAX_ID")
	private Tax tax;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExternalUniqueKey() {
		return externalUniqueKey;
	}

	public void setExternalUniqueKey(String externalUniqueKey) {
		this.externalUniqueKey = externalUniqueKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPurchesePrice() {
		return purchesePrice;
	}

	public void setPurchesePrice(Double purchesePrice) {
		this.purchesePrice = purchesePrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}
}
