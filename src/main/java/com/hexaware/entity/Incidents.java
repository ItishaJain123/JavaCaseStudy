package com.hexaware.entity;

import java.time.LocalDate;

public class Incidents {

	private int incidentId;
	private String incidentType;
	private LocalDate incidentDate;
	private String location;
	private String description;
	private String status;
	private Victims victim;
	private Suspects suspect;

	public Incidents() {
		super();
	}

	public Incidents(int incidentId, String incidentType, LocalDate incidentDate, String location, String description,
			String status, Victims victim, Suspects suspect, LawEnforcementAgencies agency) {
		super();
		this.incidentId = incidentId;
		this.incidentType = incidentType;
		this.incidentDate = incidentDate;
		this.location = location;
		this.description = description;
		this.status = status;
		this.victim = victim;
		this.suspect = suspect;
	}

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public LocalDate getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(LocalDate incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Victims getVictim() {
		return victim;
	}

	public void setVictim(Victims victim) {
		this.victim = victim;
	}

	public Suspects getSuspect() {
		return suspect;
	}

	public void setSuspect(Suspects suspect) {
		this.suspect = suspect;
	}

	@Override
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", incidentType=" + incidentType + ", incidentDate="
				+ incidentDate + ", location=" + location + ", description=" + description + ", status=" + status
				+ ", \nvictim=" + victim + ", \nsuspect=" + suspect + "]\n";
	}
}

