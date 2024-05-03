package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	// Id & zmienne
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

	// Relacje

	// Relacja jeden do jednego pomiędzy Patient a Address, dwukierunkowa,
	// Patient zna "swój" adres, a Address wie jaki pacjent pod tym adresem zamieszkuję,
	// Patient jako rodzic dla Adresu
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private AddressEntity address;

	// Relacja jeden do wielu pomiędzy Patient a Visit, dwukierunkowa,
	// Patient może mieć wiele wizyt, jedna wizyta przypisana do konkretnego doktora,
	// Patient jest rodzicem dla Visit
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "patient")
	private Collection<VisitEntity> visitEntities;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// gettery & settery
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

}
