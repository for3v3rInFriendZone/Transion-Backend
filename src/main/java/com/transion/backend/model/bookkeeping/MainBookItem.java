package com.transion.backend.model.bookkeeping;

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

import com.transion.backend.model.chartofaccounts.ChartOfAccountsOrder;

@Entity
@Table(name = "MAINBOOKITEM")
public class MainBookItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "KONTO_ID")
	private ChartOfAccountsOrder konto;
	
	@OneToMany
	@JoinColumn(name = "MAINBOOKITEM_ID")
	private List<Change> changes = new ArrayList<Change>();
	
	@Column(name = "OWINGSALDO")
	private Double owingSaldo;
	
	@Column(name = "LOOKINGSALDO")
	private Double lookingSaldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChartOfAccountsOrder getKonto() {
		return konto;
	}

	public void setKonto(ChartOfAccountsOrder konto) {
		this.konto = konto;
	}

	public Double getOwingSaldo() {
		return owingSaldo;
	}

	public void setOwingSaldo(Double owingSaldo) {
		this.owingSaldo = owingSaldo;
	}

	public Double getLookingSaldo() {
		return lookingSaldo;
	}

	public void setLookingSaldo(Double lookingSaldo) {
		this.lookingSaldo = lookingSaldo;
	}
}
