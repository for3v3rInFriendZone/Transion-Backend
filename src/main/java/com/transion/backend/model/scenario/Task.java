package com.transion.backend.model.scenario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transion.backend.model.Client;
import com.transion.backend.model.Transaction;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "TASK")
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "LABEL", nullable = false)
	private String label;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "client_task", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
	private List<Client> clients = new ArrayList<Client>();

	@OneToMany(mappedBy = "task")
	private List<Media> medias = new ArrayList<Media>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "transaction_task", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "transaction_id"))
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Media> getMedias() {
		return medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
