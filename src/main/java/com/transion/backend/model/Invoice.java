package com.transion.backend.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@Column(name = "LASTDAYTOPAY")
	private Date lastDayToPay;
	
	@ManyToOne
	@JoinColumn(name = "CREATEDBY_ID", nullable = false)
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(name = "TOPAY_ID")
	private Client toPay;
	
	@ManyToOne
	@JoinColumn(name = "TOSOLD_ID")
	private Client toSold;
	
	@ManyToOne
	@JoinColumn(name = "TAX_ID", nullable = false)
	private Tax tax;
	
	@OneToMany
	@JoinColumn(name = "INVOICE_ID", referencedColumnName = "id")
	private List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
	
	@ManyToOne
	@JoinColumn(name = "TEMPLATE_URL")
	private Document template;
	
	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private InvoiceType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Client getToPay() {
		return toPay;
	}

	public void setToPay(Client toPay) {
		this.toPay = toPay;
	}

	public Client getToSold() {
		return toSold;
	}

	public void setToSold(Client toSold) {
		this.toSold = toSold;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public Document getTemplate() {
		return template;
	}

	public void setTemplate(Document template) {
		this.template = template;
	}

	public InvoiceType getType() {
		return type;
	}

	public void setType(InvoiceType type) {
		this.type = type;
	}
	
}
