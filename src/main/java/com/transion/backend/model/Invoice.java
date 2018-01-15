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

/**
 * Faktura koju ce popunjavati klijenti, a na osnovu njih knjigovodje ce
 * popunjavati konta(dnevnik i glavnu knjigu)
 */
@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "EXTERNALUNIQUEKEY", nullable = false, unique = true)
	private String externalUniqueKey;

	/**
	 * Klijent za koga se popunjava faktura, onaj kome prodajemo. Podatke o nasoj
	 * kompaniji cemo izvlaciti iz podesavanja.
	 */
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	/**
	 * Ukupan iznos fakture.
	 */
	@Column(name = "AMOUNT")
	private Double amount;

	/**
	 * Iznos bez PDV-a. Mozda bi bilo pametno odvojiti PDV, 20% i 10%.
	 */
	@Column(name = "AMOUNTWITHOUTTAX")
	private Double amountWithoutTax;

	/**
	 * Iznos samog PDV-a.
	 */
	@Column(name = "TAXAMOUNT")
	private Double taxAmount;

	/**
	 * Artikli koji ce se nalaziti na fakturi.
	 */
	@OneToMany
	@JoinColumn(name = "INVOICE_ID", referencedColumnName = "id")
	private List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();

	@Column(name = "CREATEDDATE")
	private Date createdDate;

	@Column(name = "CURRENCYDATE")
	private Date currencyDate;

	@Column(name = "LASTDAYTOPAY")
	private Date lastDayToPay;

	@Column(name = "paidDate")
	private Date paidDate;

	@ManyToOne
	@JoinColumn(name = "CREATEDBY_ID", nullable = false)
	private User createdBy;

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

	public Double getAmountWithoutTax() {
		return amountWithoutTax;
	}

	public void setAmountWithoutTax(Double amountWithoutTax) {
		this.amountWithoutTax = amountWithoutTax;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastDayToPay() {
		return lastDayToPay;
	}

	public void setLastDayToPay(Date lastDayToPay) {
		this.lastDayToPay = lastDayToPay;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(Date currencyDate) {
		this.currencyDate = currencyDate;
	}
}
