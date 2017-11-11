package com.transion.backend.model.scenario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.transion.backend.model.Client;
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

	@ManyToOne
	@JoinColumn(name = "STEP_ID")
	private ScenarioStep step;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	public Task() {
		
	}

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

	public ScenarioStep getStep() {
		return step;
	}

	public void setStep(ScenarioStep step) {
		this.step = step;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
