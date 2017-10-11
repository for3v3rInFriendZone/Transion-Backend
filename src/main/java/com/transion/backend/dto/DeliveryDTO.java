package com.transion.backend.dto;

import java.util.ArrayList;
import java.util.List;
import com.transion.backend.model.Invoice;
import com.transion.backend.model.User;

public class DeliveryDTO {

	private Long id;
	private UserDTO createdBy;
	private UserDTO deliverer;
	private List<InvoiceDTO> invoices = new ArrayList<InvoiceDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDTO createdBy) {
		this.createdBy = createdBy;
	}

	public UserDTO getDeliverer() {
		return deliverer;
	}

	public void setDeliverer(UserDTO deliverer) {
		this.deliverer = deliverer;
	}

	public List<InvoiceDTO> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<InvoiceDTO> invoices) {
		this.invoices = invoices;
	}

}
