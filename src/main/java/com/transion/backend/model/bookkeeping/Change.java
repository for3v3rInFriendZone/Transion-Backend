package com.transion.backend.model.bookkeeping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.transion.backend.model.Invoice;
import com.transion.backend.model.chartofaccounts.ChartOfAccountsOrder;

/**
 * Promena koju unosi knjigovodja.
 */
@Entity
@Table(name = "CHANGE")
public class Change implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "OWINGKONTO_ID")
	private ChartOfAccountsOrder owingKonto;
	
	@ManyToOne
	@JoinColumn(name = "LOOKINGKONTO_ID")
	private ChartOfAccountsOrder lookingKonto;
	
	@Column(name = "OWING")
	private Double owing;
	
	@Column(name = "LOOKING")
	private Double looking;
	
	@ManyToOne
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChartOfAccountsOrder getOwingKonto() {
		return owingKonto;
	}

	public void setOwingKonto(ChartOfAccountsOrder owingKonto) {
		this.owingKonto = owingKonto;
	}

	public ChartOfAccountsOrder getLookingKonto() {
		return lookingKonto;
	}

	public void setLookingKonto(ChartOfAccountsOrder lookingKonto) {
		this.lookingKonto = lookingKonto;
	}

	public Double getOwing() {
		return owing;
	}

	public void setOwing(Double owing) {
		this.owing = owing;
	}

	public Double getLooking() {
		return looking;
	}

	public void setLooking(Double looking) {
		this.looking = looking;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
