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
public class BookOfReceiptsItem implements Serializable {

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

	@Column(name = "AMOUNTWITHTAX")
	private Double amountWithTax;

	/**
	 * Oslobodjene nabavke i nabavke od lica koja nisu obveznici PDV-a
	 */
	@Column(name = "TAXFREE")
	private Double taxFree;

	/**
	 * Naknada za uvezena dobra na koje se ne placa PDV
	 */
	@Column(name = "IMPORTTAXFREE")
	private Double importTaxFree;

	/**
	 * Naknada bez PDV-a (na koju je obracunat PDV koji se moze odbiti)
	 */
	@Column(name = "FEEWITHOUTTAX")
	private Double feeWithoutTax;

	/**
	 * Ukupan iznos obracunatog predhodnog PDV-a
	 */
	@Column(name = "LASTTAXAMOUNT")
	private Double lastTaxAmount;

	/**
	 * Iznos predhodnog PDV-a koji se moze odbiti
	 */
	@Column(name = "REJECTEDTAXAMOUNT")
	private Double rejectedTaxAmount;

	/**
	 * Iznos predhodnog PDV-a koji se ne moze odbiti
	 */
	@Column(name = "NOTREJECTEDTAXAMOUNT")
	private Double notRejectedTaxAmont;

	/**
	 * Vrednost bez PDV-a uvoza
	 */
	@Column(name = "IMPORTWITHTAX")
	private Double importWithTax;

	/**
	 * Vrednost PDV-a uvoza
	 */
	@Column(name = "IMPORTWITHOUTTAX")
	private Double importWithoutTax;

	public Long getId() {
		return id;
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

	public Double getAmountWithTax() {
		return amountWithTax;
	}

	public void setAmountWithTax(Double amountWithTax) {
		this.amountWithTax = amountWithTax;
	}

	public Double getTaxFree() {
		return taxFree;
	}

	public void setTaxFree(Double taxFree) {
		this.taxFree = taxFree;
	}

	public Double getImportTaxFree() {
		return importTaxFree;
	}

	public void setImportTaxFree(Double importTaxFree) {
		this.importTaxFree = importTaxFree;
	}

	public Double getFeeWithoutTax() {
		return feeWithoutTax;
	}

	public void setFeeWithoutTax(Double feeWithoutTax) {
		this.feeWithoutTax = feeWithoutTax;
	}

	public Double getLastTaxAmount() {
		return lastTaxAmount;
	}

	public void setLastTaxAmount(Double lastTaxAmount) {
		this.lastTaxAmount = lastTaxAmount;
	}

	public Double getRejectedTaxAmount() {
		return rejectedTaxAmount;
	}

	public void setRejectedTaxAmount(Double rejectedTaxAmount) {
		this.rejectedTaxAmount = rejectedTaxAmount;
	}

	public Double getNotRejectedTaxAmont() {
		return notRejectedTaxAmont;
	}

	public void setNotRejectedTaxAmont(Double notRejectedTaxAmont) {
		this.notRejectedTaxAmont = notRejectedTaxAmont;
	}

	public Double getImportWithTax() {
		return importWithTax;
	}

	public void setImportWithTax(Double importWithTax) {
		this.importWithTax = importWithTax;
	}

	public Double getImportWithoutTax() {
		return importWithoutTax;
	}

	public void setImportWithoutTax(Double importWithoutTax) {
		this.importWithoutTax = importWithoutTax;
	}

}
