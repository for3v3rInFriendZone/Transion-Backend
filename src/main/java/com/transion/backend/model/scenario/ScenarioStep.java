package com.transion.backend.model.scenario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCENARIO_STEP")
public class ScenarioStep implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STEP_DELAY")
	private Long delay;

	@ManyToOne
	@JoinColumn(name = "SCENARIO_ID")
	private Scenario scenario;

	@ManyToOne
	@JoinColumn(name = "MEDIA_ID")
	private Media media;

	public ScenarioStep() {

	}

	public ScenarioStep(String name) {
		super();
		this.name = name;
	}

	public ScenarioStep(String name, Long delay) {
		super();
		this.name = name;
		this.delay = delay;
	}

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

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

}
