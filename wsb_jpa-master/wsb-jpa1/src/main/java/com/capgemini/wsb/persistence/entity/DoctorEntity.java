package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	// Id & zmienne //

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", length = 25, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 25, nullable = false)
	private String lastName;

	@Column(name = "phone_number", length = 15, nullable = true)
	private String telephoneNumber;

	@Column(name = "e_mail", length = 50, nullable = true)
	private String email;

	@Column(name = "doctor_number", length = 50, nullable = false)
	private String doctorNumber;
	@Column(name = "Specialization", length = 30, nullable = true)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;


	// Relacje //
	/**
	 * Relacja dwukierunkowa pomiędzy Doctor a Address, jeden do jednego.
	 * Każdy doktor ma jedne adres, każdy adres może należeć do jednego doktora.
	 * Doctor jako ojciec w tej relacji
	 **/
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private AddressEntity address;

	/**
	 * Relacja dwukierunkowa pomiędzy Doctor a Visit, jeden do wielu.
	 * Każdy doktor może mieć wiele wizyt, każda wizyta przypisana do jednego doktora.
	 * Doctor jako ojciec w tej relacji
	 **/
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "doctor")
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

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
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
