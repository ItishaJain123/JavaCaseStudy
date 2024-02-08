package com.hexaware.entity;

public class Officers {

	private int officerId;
	private String firstName;
	private String lastName;
	private String badgeNo;
	private String rank;
	private String contactInfo;
	private LawEnforcementAgencies agency;

	public Officers() {
		super();
	}

	public Officers(int officerId, String firstName, String lastName, String badgeNo, String rank, String contactInfo,
			LawEnforcementAgencies agency) {
		super();
		this.officerId = officerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.badgeNo = badgeNo;
		this.rank = rank;
		this.contactInfo = contactInfo;
		this.agency = agency;
	}

	public int getOfficerId() {
		return officerId;
	}

	public void setOfficerId(int officerId) {
		this.officerId = officerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBadgeNo() {
		return badgeNo;
	}

	public void setBadgeNo(String badgeNo) {
		this.badgeNo = badgeNo;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public LawEnforcementAgencies getAgency() {
		return agency;
	}

	public void setAgency(LawEnforcementAgencies agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {
		return "Officers [officerId=" + officerId + ", firstName=" + firstName + ", lastName=" + lastName + ", badgeNo="
				+ badgeNo + ", rank=" + rank + ", contactInfo=" + contactInfo + ", agency=" + agency + "]";
	}
}
