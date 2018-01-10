package com.transion.backend.model.bookkeeping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transion.backend.model.Client;
import com.transion.backend.model.Invoice;

@Entity
@Table(name = "INVOICEBOOKITEM")
public class BookOfIssuedInvoiceItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "SERIALNUMBER")
	private Long serialNumber;
	
	@ManyToOne
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	@Column(name = "TAX")
	private Double tax;
	
	/**
	 * Pravo na naplatu. 
	 */
	@Column(name = "RIGHTTODEDUCTION")
	private Double rightToDeduction;
	
	/**
	 * Bez prava na naplatu.
	 */
	@Column(name = "WITHOUTRIGHTTODEDUCTION")
	private Double withoutRightToDeduction;
	
	/**
	 * Prava na naplatu iz faktura iz inostranstva.
	 */
	@Column(name = "FOREINGRIGHTDEDUCT")
	private Double foreingRightDeduct;
	
	/**
	 * Bez prava na naplatu faktura iz inostranstva.
	 */
	@Column(name = "FOREINGWITHOUTDEDUCTION")
	private Double foreingWithoutDeduct;
	
	/**
	 * Osnovica za PDV od 20%.
	 */
	@Column(name = "TAX20FEE")
	private Double tax20Fee;
	
	/**
	 * Iznos PDV-a od 20%.
	 */
	@Column(name = "TAX20AMOUNT")
	private Double tax20Amount;
	
	/**
	 * Osnovica za PDV od 10%.
	 */
	@Column(name = "TAX10FEE")
	private Double tax10Fee;
	
	/**
	 * Iznos PDV-a od 10%.
	 */
	@Column(name = "TAX10AMOUNT")
	private Double tax10Amount;
	
	/**
	 * Osnovica za avans gde je PDV 20%.
	 */
	@Column(name = "AVANS20FEE")
	private Double avans20Fee;
	
	/**
	 * Iznos avansa gde je PDV 20%.
	 */
	@Column(name = "AVANS20AMOUNT")
	private Double avans20Amount;
	
	/**
	 * Osnovica avansa gde je PDV 10%.
	 */
	@Column(name = "AVANS10FEE")
	private Double avans10Fee;
	
	/**
	 * Iznos avansa gde je PDV 10% 
	 */
	@Column(name = "AVANS10AMOUNT")
	private Double avans10Amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
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

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
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

	public Double getTax20Fee() {
		return tax20Fee;
	}

	public void setTax20Fee(Double tax20Fee) {
		this.tax20Fee = tax20Fee;
	}

	public Double getTax20Amount() {
		return tax20Amount;
	}

	public void setTax20Amount(Double tax20Amount) {
		this.tax20Amount = tax20Amount;
	}

	public Double getTax10Fee() {
		return tax10Fee;
	}

	public void setTax10Fee(Double tax10Fee) {
		this.tax10Fee = tax10Fee;
	}

	public Double getTax10Amount() {
		return tax10Amount;
	}

	public void setTax10Amount(Double tax10Amount) {
		this.tax10Amount = tax10Amount;
	}

	public Double getAvans20Fee() {
		return avans20Fee;
	}

	public void setAvans20Fee(Double avans20Fee) {
		this.avans20Fee = avans20Fee;
	}

	public Double getAvans20Amount() {
		return avans20Amount;
	}

	public void setAvans20Amount(Double avans20Amount) {
		this.avans20Amount = avans20Amount;
	}

	public Double getAvans10Fee() {
		return avans10Fee;
	}

	public void setAvans10Fee(Double avans10Fee) {
		this.avans10Fee = avans10Fee;
	}

	public Double getAvans10Amount() {
		return avans10Amount;
	}

	public void setAvans10Amount(Double avans10Amount) {
		this.avans10Amount = avans10Amount;
	}
	
	
}
