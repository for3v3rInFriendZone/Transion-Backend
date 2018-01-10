package com.transion.backend.model.bookkeeping;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.transion.backend.model.Client;
import com.transion.backend.model.Invoice;

@Entity
@Table(name = "BOOKOFRECEIPTSITEM")
public class BookOfReceiptsItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "SERIALNUMBER")
	private String serialNumber;
	
	@Column(name = "CRATEDDATE")
	private Date createdDate;
	
	@Column(name = "CUSTOMDECLARATION")
	private String customDeclaration;
	
	@ManyToOne
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	@Column(name = "TAXAMOUNT")
	private Double taxAmount;

	/**
	 * Ostatak treba dodati....
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomDeclaration() {
		return customDeclaration;
	}

	public void setCustomDeclaration(String customDeclaration) {
		this.customDeclaration = customDeclaration;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	
	
}
