package com.transion.backend.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.transion.backend.model.Client;
import com.transion.backend.model.Document;
import com.transion.backend.model.InvoiceItem;
import com.transion.backend.model.InvoiceType;
import com.transion.backend.model.Tax;
import com.transion.backend.model.User;

public class InvoiceDTO {

	private Long id;
	private Double amount;
	private Date lastDayToPay;
	private UserDTO createdBy;
	private ClientDTO toPay;
	private ClientDTO toSold;
	private TaxDTO tax;
	private List<InvoiceItemDTO> invoiceItems = new ArrayList<InvoiceItemDTO>();
	private DocumentDTO template;
	private InvoiceTypeDTO type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getLastDayToPay() {
		return lastDayToPay;
	}

	public void setLastDayToPay(Date lastDayToPay) {
		this.lastDayToPay = lastDayToPay;
	}

	public UserDTO getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDTO createdBy) {
		this.createdBy = createdBy;
	}

	public ClientDTO getToPay() {
		return toPay;
	}

	public void setToPay(ClientDTO toPay) {
		this.toPay = toPay;
	}

	public ClientDTO getToSold() {
		return toSold;
	}

	public void setToSold(ClientDTO toSold) {
		this.toSold = toSold;
	}

	public TaxDTO getTax() {
		return tax;
	}

	public void setTax(TaxDTO tax) {
		this.tax = tax;
	}

	public List<InvoiceItemDTO> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItemDTO> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public DocumentDTO getTemplate() {
		return template;
	}

	public void setTemplate(DocumentDTO template) {
		this.template = template;
	}

	public InvoiceTypeDTO getType() {
		return type;
	}

	public void setType(InvoiceTypeDTO type) {
		this.type = type;
	}

}
