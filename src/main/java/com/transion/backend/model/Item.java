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
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "EXTERNALKEY", nullable = false, unique = true)
	private String externalUniqueKey;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCRITION")
	private String description;

	/**
	 * Garancija
	 */
	@Column(name = "WARRANTY")
	private Long warranty;

	/**
	 * Dobavljac
	 */
	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID", nullable = false)
	private Client supplier;

	@Column(name = "PURCHASEPRICE", nullable = false)
	private Double purchasePrice;

	@Column(name = "SELLINGPRICE", nullable = false)
	private Double sellingPrice;

	@ManyToOne
	@JoinColumn(name = "MEASURE_ID")
	private Measure measure;

	@ManyToOne
	@JoinColumn(name = "TAX_ID", nullable = false)
	private Tax tax;

	// Oni stavljaju i konto na artikal, razmisliti o tome

	public Long getId() {
		return id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getWarranty() {
		return warranty;
	}

	public void setWarranty(Long warranty) {
		this.warranty = warranty;
	}

	public Client getSupplier() {
		return supplier;
	}

	public void setSupplier(Client supplier) {
		this.supplier = supplier;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

}
