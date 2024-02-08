package com.hexaware.entity;

import java.time.LocalDate;

public class Victims {

	private int victimId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String gender;
	private String address;
	private String phone;

	public Victims() {
		super();
	}

	public Victims(int victimId, String firstName, String lastName, LocalDate dob, String gender, String address,
			String phone) {
		super();
		this.victimId = victimId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
	}

	public int getVictimId() {
		return victimId;
	}

	public void setVictimId(int victimId) {
		this.victimId = victimId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Victims [victimId=" + victimId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", address=" + address + ", phone=" + phone + "]";
	}
}
