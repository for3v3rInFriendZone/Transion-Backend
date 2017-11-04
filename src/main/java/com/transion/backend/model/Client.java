package com.transion.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transion.backend.model.address.Address;
import com.transion.backend.model.scenario.Task;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "PIB", nullable = false, unique = true, length = 9)
	private String pib;

	@Column(name = "EXTERNALUNIQUEKEY", nullable = false, unique = true, length = 8)
	private String externalUniqueKey;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "EMAIL")
	private String email;

	@ManyToOne()
	@JoinColumn(name = "RESPONSIBLEUSER_ID", nullable = false)
	private ResponsibleUser responsibleUser;

	@ManyToOne()
	@JoinColumn(name = "ADDRESS_ID", nullable = false)
	private Address address;

	@Column(name = "CREATEDON")
	private Date createdOn;

	@Column(name = "UPDATEDON")
	private Date updatedOn;
	
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

}
