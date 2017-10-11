package com.transion.backend.dto;

import java.util.ArrayList;
import java.util.List;
import com.transion.backend.model.Document;
import com.transion.backend.model.Transaction;

public class ReportDTO {

	private Long id;
	private DocumentDTO template;
	private List<TransactionDTO> transactions = new ArrayList<TransactionDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DocumentDTO getTemplate() {
		return template;
	}

	public void setTemplate(DocumentDTO template) {
		this.template = template;
	}

	public List<TransactionDTO> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDTO> transactions) {
		this.transactions = transactions;
	}

}
