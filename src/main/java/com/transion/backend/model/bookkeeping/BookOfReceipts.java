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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Knjiga primljenih racuna.
 */
@Entity
@Table(name = "BOOKOFRECEIPTS")
public class BookOfReceipts implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "BOOKOFRECEIPTS_ID", referencedColumnName = "id")
	private List<BookOfReceiptsItem> items = new ArrayList<BookOfReceiptsItem>();
	
	@Column(name = "TAXSUMAMOUNT")
	private Double taxSumAmount;

	/**
	 * treba napraviti ostala sum polja za ostale PDV-ove
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<BookOfReceiptsItem> getItems() {
		return items;
	}

	public void setItems(List<BookOfReceiptsItem> items) {
		this.items = items;
	}

	public Double getTaxSumAmount() {
		return taxSumAmount;
	}

	public void setTaxSumAmount(Double taxSumAmount) {
		this.taxSumAmount = taxSumAmount;
	}
	
}
