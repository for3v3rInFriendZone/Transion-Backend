package com.transion.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICEITEM")
public class InvoiceItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "TAXPRICE")
	private Double taxPrice;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name = "TAX_ID")
	private Tax tax;
	
	@Column(name = "TAXAMOUNT")
	private Double taxAmount;
	
	@Column(name = "RABAT")
	private Double rabat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(Double taxPrice) {
		this.taxPrice = taxPrice;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getRabat() {
		return rabat;
	}

	public void setRabat(Double rabat) {
		this.rabat = rabat;
	}	
}
