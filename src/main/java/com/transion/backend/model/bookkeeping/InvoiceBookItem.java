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
public class InvoiceBookItem implements Serializable{

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
	
	@ManyToOne
	@JoinColumn(name = "FREETRAFIC_ID")
	private FreeTraffic freeTrafic;
	
	@Column(name = "TAX20FEE")
	private Double tax20Fee;
	
	@Column(name = "TAX20AMOUNT")
	private Double tax20Amount;
	
	@Column(name = "TAX10FEE")
	private Double tax10Fee;
	
	@Column(name = "TAX10AMOUNT")
	private Double tax10Amount;
	
	@Column(name = "AVANS20FEE")
	private Double avans20Fee;
	
	@Column(name = "AVANS20AMOUNT")
	private Double avans20Amount;
	
	@Column(name = "AVANS10FEE")
	private Double avans10Fee;
	
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

	public FreeTraffic getFreeTrafic() {
		return freeTrafic;
	}

	public void setFreeTrafic(FreeTraffic freeTrafic) {
		this.freeTrafic = freeTrafic;
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
