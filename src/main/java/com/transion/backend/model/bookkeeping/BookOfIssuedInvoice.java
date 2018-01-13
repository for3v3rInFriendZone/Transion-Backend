package com.transion.backend.model.bookkeeping;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.transion.backend.model.Client;
import com.transion.backend.model.Invoice;

/**
 * Knjiga izdatih racuna, racuni koje kompanija izdaje. 
 */
@Entity
@Table(name = "InvoiceBook")
public class BookOfIssuedInvoice implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Klijent za koga se knjigovodja radi.
	 */
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	/**
	 * Artikli koji se unose u knjigu izdatih racuna.
	 */
	@OneToMany
	@JoinColumn(name = "BOOKOFISSUEDINVOICE_ID", referencedColumnName = "id")
	private List<BookOfIssuedInvoiceItem> items = new ArrayList<BookOfIssuedInvoiceItem>();
	
	@Column(name = "TAXSUM")
	private Double taxSum;
	
	@Column(name = "TAX20FEESUM")
	private Double tax20FeeSum;
	
	@Column(name = "TAX20AMOUNTSUM")
	private Double tax20AmountSum;
	
	@Column(name = "TAX10FEESUM")
	private Double tax10FeeSum;
	
	@Column(name = "TAX10AMOUNTSUM")
	private Double tax10AmountSum;
	
	@Column(name = "AVANS20FEESUM")
	private Double avans20FeeSum;
	
	@Column(name = "AVANS20AMOUNTSUM")
	private Double avans20AmountSum;
	
	@Column(name = "AVANS10FEESUM")
	private Double avans10FeeSum;
	
	@Column(name = "AVANS10AMOUNTSUM")
	private Double avans10AmountSum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<BookOfIssuedInvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<BookOfIssuedInvoiceItem> items) {
		this.items = items;
	}

	public Double getTaxSum() {
		return taxSum;
	}

	public void setTaxSum(Double taxSum) {
		this.taxSum = taxSum;
	}

	public Double getTax20FeeSum() {
		return tax20FeeSum;
	}

	public void setTax20FeeSum(Double tax20FeeSum) {
		this.tax20FeeSum = tax20FeeSum;
	}

	public Double getTax20AmountSum() {
		return tax20AmountSum;
	}

	public void setTax20AmountSum(Double tax20AmountSum) {
		this.tax20AmountSum = tax20AmountSum;
	}

	public Double getTax10FeeSum() {
		return tax10FeeSum;
	}

	public void setTax10FeeSum(Double tax10FeeSum) {
		this.tax10FeeSum = tax10FeeSum;
	}

	public Double getTax10AmountSum() {
		return tax10AmountSum;
	}

	public void setTax10AmountSum(Double tax10AmountSum) {
		this.tax10AmountSum = tax10AmountSum;
	}

	public Double getAvans20FeeSum() {
		return avans20FeeSum;
	}

	public void setAvans20FeeSum(Double avans20FeeSum) {
		this.avans20FeeSum = avans20FeeSum;
	}

	public Double getAvans20AmountSum() {
		return avans20AmountSum;
	}

	public void setAvans20AmountSum(Double avans20AmountSum) {
		this.avans20AmountSum = avans20AmountSum;
	}

	public Double getAvans10FeeSum() {
		return avans10FeeSum;
	}

	public void setAvans10FeeSum(Double avans10FeeSum) {
		this.avans10FeeSum = avans10FeeSum;
	}

	public Double getAvans10AmountSum() {
		return avans10AmountSum;
	}

	public void setAvans10AmountSum(Double avans10AmountSum) {
		this.avans10AmountSum = avans10AmountSum;
	}
}
