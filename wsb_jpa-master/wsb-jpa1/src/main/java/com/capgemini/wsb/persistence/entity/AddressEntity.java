package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	// Id & zmienne. //
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "city", length = 80, nullable = false)
	private String city;
	@Column(name = "address_line1", length = 40, nullable = false)
	private String addressLine1;
	@Column(name = "address_line2", length = 40, nullable = false)
	private String addressLine2;
	@Column(name = "postal_code", length = 10, nullable = false)
	private String postalCode;

	// Relacje //
	/**
 	* Relacja dwukierunkowa pomiędzy Doctor a Adress, jeden do jednego.
 	* Każdy z doktorów posiada jeden adres, każdy adres może należeć do jednego doktora.
	**/

	@OneToOne(mappedBy = "address")
	private DoctorEntity doctor;

	 /**
	 * Relacja dwukierunkowa pomiędzy Doctor a Patient, jeden do jednego.
	 * Każdy z pacjentów posiada jeden adres, każdy adres może należeć do jednego pacjenta.
	 **/
	@OneToOne(mappedBy = "address")
	private PatientEntity patient;


	// gettery & settery //

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
}

// Push Test 3