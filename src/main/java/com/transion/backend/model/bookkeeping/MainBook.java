package com.transion.backend.model.bookkeeping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transion.backend.model.Client;

@Entity
@Table(name = "MAINBOOK")
public class MainBook implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	@OneToMany
	@JoinColumn(name = "MAINBOOK_ID", referencedColumnName = "id")
	private List<MainBookItem> items = new ArrayList<MainBookItem>();

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

	public List<MainBookItem> getItems() {
		return items;
	}

	public void setItems(List<MainBookItem> items) {
		this.items = items;
	}
}
