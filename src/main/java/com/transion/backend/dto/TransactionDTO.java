package com.transion.backend.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.transion.backend.model.Client;
import com.transion.backend.model.Comment;
import com.transion.backend.model.Dispute;
import com.transion.backend.model.TransactionStatus;

public class TransactionDTO {

	private Long id;
	private Date lastDayToPay;
	private Date payDate;
	private Integer delay;
	private Double amount;
	private TransactionStatusDTO status;
	private ClientDTO client;
	private List<DisputeDTO> disputes = new ArrayList<DisputeDTO>();
	private List<CommentDTO> comments = new ArrayList<CommentDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLastDayToPay() {
		return lastDayToPay;
	}

	public void setLastDayToPay(Date lastDayToPay) {
		this.lastDayToPay = lastDayToPay;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionStatusDTO getStatus() {
		return status;
	}

	public void setStatus(TransactionStatusDTO status) {
		this.status = status;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public List<DisputeDTO> getDisputes() {
		return disputes;
	}

	public void setDisputes(List<DisputeDTO> disputes) {
		this.disputes = disputes;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

}
