package com.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appointment_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "appointment_date")
	private Date appointmentDate;

	@Column(name = "location")
	private String location;

	@Column(name = "description")
	private String description;

	@Column(name = "confirmed")
	private boolean confirmed;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Appointment() {
	}

	public Appointment(Date appointmentDate, String location, String description, boolean confirmed) {
		this.appointmentDate = appointmentDate;
		this.location = location;
		this.description = description;
		this.confirmed = confirmed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
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

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
