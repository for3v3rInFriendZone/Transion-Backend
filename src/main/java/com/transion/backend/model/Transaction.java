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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transion.backend.model.importexport.Field;
import com.transion.backend.model.scenario.Media;
import com.transion.backend.model.scenario.Task;
import com.transion.backend.util.ImportEnum;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "LASTDATETOPAY", nullable = false)
	private Date lastDayToPay;

	@Column(name = "PAYDATE")
	private Date payDate;

	@Column(name = "DELAY")
	private Integer delay;

	@Column(name = "AMOUNT", nullable = false)
	private Double amount;

	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private TransactionStatus status;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID", nullable = false)
	private Client client;

	@OneToMany
	@JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "id")
	private List<Dispute> disputes = new ArrayList<Dispute>();

	@OneToMany
	@JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "id")
	private List<Comment> comments = new ArrayList<Comment>();

	@ManyToOne
	@JoinColumn(name = "TASK_ID")
	private Task task;

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

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Dispute> getDisputes() {
		return disputes;
	}

	public void setDisputes(List<Dispute> disputes) {
		this.disputes = disputes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	public static List<Field> transactionsFields(){
		List<Field> fields = new ArrayList<Field>();
		
		fields.add(new Field("Last day to pay", "Date", true, ImportEnum.TRANSACTION_LASTDAYTOPAY));
		fields.add(new Field("Pay date", "Date", false, ImportEnum.TRANSACTION_PAYDATE));
		fields.add(new Field("Delay", "Integer", false, ImportEnum.TRANSACTION_DELAY));
		fields.add(new Field("Amount", "Double", true, ImportEnum.TRANSACTION_AMOUNT));
		fields.add(new Field("Status", "Long", false, ImportEnum.TRANSACTION_STATUS));
		fields.add(new Field("Client", "String", true, ImportEnum.TRANSACTION_CLIENT));
		
		return fields;
	}

}
