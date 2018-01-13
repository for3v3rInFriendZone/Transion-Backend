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

/**
 * Dnevnik knjizenja, ovde se ubacuju sva konta(nalozi) koja se naprave i unose se hronoloskim redosledom. 
 * Sva racunanja na kraju moraju biti 0 (duguje-potrazuje=0). Ovo ce videti knjigovodje i stavke ce se automatski dodavati.
 */
@Entity
@Table(name = "ACCOUNTINGDIARY")
public class AccountingDiary implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Klijent za koga se pravi dnevnik (klijent koji pravi fakture, a za koja radi knjigovodja).
	 */
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	/**
	 * Sve promene koje su nastale, a vezane su za knjizenje faktura.
	 */
	@OneToMany
	@JoinColumn(name = "ACCOUNTINGDIARY_ID", referencedColumnName = "id")
	private List<ChangeOrder> changeOrders = new ArrayList<ChangeOrder>();
	
	/**
	 * Saldo za duguje.
	 */
	@Column(name = "OWINGSALDO")
	private Double owingSaldo;
	
	/**
	 * Saldo za potrazuje.
	 */
	@Column(name = "LOOKINGSALDO")
	private Double lookingSaldo;

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

	public List<ChangeOrder> getChangeOrders() {
		return changeOrders;
	}

	public void setChangeOrders(List<ChangeOrder> changeOrders) {
		this.changeOrders = changeOrders;
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
