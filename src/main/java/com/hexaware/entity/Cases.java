package com.hexaware.entity;

public class Cases {

	private int caseId;
	private String caseDescription;
	private Incidents relatedIncidents;

	public Cases() {
	}

	public Cases(int caseId, String caseDescription, Incidents relatedIncidents) {
		super();
		this.caseId = caseId;
		this.caseDescription = caseDescription;
		this.relatedIncidents = relatedIncidents;
	}

	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	public String getCaseDescription() {
		return caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}

	public Incidents getRelatedIncidents() {
		return relatedIncidents;
	}

	public void setRelatedIncidents(Incidents relatedIncidents) {
		this.relatedIncidents = relatedIncidents;
	}

	@Override
	public String toString() {
		return "Cases [caseId=" + caseId + ", caseDescription=" + caseDescription + ",\nrelatedIncident="
				+ relatedIncidents + "]\n";
	}
}
