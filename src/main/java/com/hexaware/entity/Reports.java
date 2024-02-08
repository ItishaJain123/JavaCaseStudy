package com.hexaware.entity;

import java.time.LocalDate;
public class Reports {

	private int reportId;
	private Incidents incident;
	private Officers reportingOfficer;
	private LocalDate reportDate;
	private String reportDetails;
	private String reportStatus;

	public Reports() {
		super();
	}

	public Reports(int reportId, Incidents incident, Officers reportingOfficer, LocalDate reportDate,
			String reportDetails, String reportStatus) {
		super();
		this.reportId = reportId;
		this.incident = incident;
		this.reportingOfficer = reportingOfficer;
		this.reportDate = reportDate;
		this.reportDetails = reportDetails;
		this.reportStatus = reportStatus;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public Incidents getIncident() {
		return incident;
	}

	public void setIncident(Incidents incident) {
		this.incident = incident;
	}

	public Officers getReportingOfficer() {
		return reportingOfficer;
	}

	public void setReportingOfficer(Officers reportingOfficer) {
		this.reportingOfficer = reportingOfficer;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportDetails() {
		return reportDetails;
	}

	public void setReportDetails(String reportDetails) {
		this.reportDetails = reportDetails;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	@Override
	public String toString() {
		return "Reports [reportId=" + reportId + ", incident=" + incident + ", reportingOfficer=" + reportingOfficer
				+ ", reportDate=" + reportDate + ", reportDetails=" + reportDetails + ", reportStatus=" + reportStatus
				+ "]";
	}
}
