package com.hexaware.entity;

import java.time.LocalDate;

public class Suspects {
	private int suspectId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String gender;
	private String contactInfo;

	public Suspects() {
		super();
	}

	public Suspects(int suspectId, String firstName, String lastName, LocalDate dob, String gender,
			String contactInfo) {
		super();
		this.suspectId = suspectId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.contactInfo = contactInfo;
	}

	public int getSuspectId() {
		return suspectId;
	}

	public void setSuspectId(int suspectId) {
		this.suspectId = suspectId;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "Suspects [suspectId=" + suspectId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", gender=" + gender + ", contactInfo=" + contactInfo + "]";
	}
}
