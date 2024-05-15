package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	// Id & zmienne //
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", length = 25, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 25, nullable = false)
	private String lastName;

	@Column(name = "phone_number", length = 9, nullable = true)
	private String telephoneNumber;

	@Column(name = "email", length = 50, nullable = true)
	private String email;

	@Column(name = "patient_number", length = 50, nullable = false)
	private String patientNumber;

	@Column(name = "date_of_birth", length = 50,nullable = false)
	private LocalDate dateOfBirth;

	 /**
	 * Dodatkowe pole o typie innym niż String, data rejestracji/dodania do bazy
	 **/
	@Column(name = "timeOfRegistration", nullable = true)
	private LocalDateTime registrationTime;

	// Relacje
	/**
	 * Relacja dwukierunkowa pomiędzy Patient a Address, jeden do jednego.
	 * Każdy pacjent ma jeden adres, każdy adres należy do jednego pacjenta.
	 * Pacjent jest nadrzędnym w relacji
	 **/
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private AddressEntity address;

	/**
	 * Relacja dwukierunkowa pomiędzy Patient a Visit, jeden do wielu.
	 * Każdy pacjent może mieć wiele wizyt, każda wizyta przypisana do tylko jednego pacjenta.
	 * Pacjent jest nadrzędnym w relacji.
	 **/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "patient")
	private Collection<VisitEntity> visitEntities;


	// gettery & settery //

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public Collection<VisitEntity> getVisitEntities() {
		return visitEntities;
	}

	public void setVisitEntities(Collection<VisitEntity> visitEntities) {
		this.visitEntities = visitEntities;
	}
}
