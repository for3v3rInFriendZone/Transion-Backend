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
@Table(name = "TRANSACTION")
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "LASTDATETOPAY")
	private Date lastDayToPay;
	
	@Column(name = "PAYDATE")
	private Date payDate;
	
	@Column(name = "DELAY")
	private Integer delay;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private TransactionStatus status;
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	@OneToMany
	private List<Dispute> disputes = new ArrayList<Dispute>();
	
	@OneToMany
	private List<Comment> comments = new ArrayList<Comment>();
}
