package com.hexaware.entity;

public class LawEnforcementAgencies {

	private int agencyId;
	private String agencyName;
	private String jurisdiction;
	private String contactInfo;

	public LawEnforcementAgencies() {
		super();
	}

	public LawEnforcementAgencies(int agencyId, String agencyName, String jurisdiction, String contactInfo) {
		super();
		this.agencyId = agencyId;
		this.agencyName = agencyName;
		this.jurisdiction = jurisdiction;
		this.contactInfo = contactInfo;
	}

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "LawEnforcementAgencies [agencyId=" + agencyId + ", agencyName=" + agencyName + ", jurisdiction="
				+ jurisdiction + ", contactInfo=" + contactInfo + "]";
	}
}