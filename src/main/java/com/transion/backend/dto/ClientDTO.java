package com.transion.backend.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.transion.backend.model.ResponsibleUser;
import com.transion.backend.model.Transaction;
import com.transion.backend.model.address.Address;

public class ClientDTO {

	private Long id;
	private String name;
	private String pib;
	private String externalUniqueKey;
	private String telephone;
	private String email;
	private ResponsibleUser responsibleUser;
	private Address address;
	private Date createdOn;
	private Date updatedOn;
	private List<TransactionDTO> transactions = new ArrayList<TransactionDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getExternalUniqueKey() {
		return externalUniqueKey;
	}

	public void setExternalUniqueKey(String externalUniqueKey) {
		this.externalUniqueKey = externalUniqueKey;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ResponsibleUser getResponsibleUser() {
		return responsibleUser;
	}

	public void setResponsibleUser(ResponsibleUser responsibleUser) {
		this.responsibleUser = responsibleUser;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<TransactionDTO> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDTO> transactions) {
		this.transactions = transactions;
	}

}
