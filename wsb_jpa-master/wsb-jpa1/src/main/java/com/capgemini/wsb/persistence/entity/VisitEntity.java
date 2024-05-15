package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	// Id & zmienne //
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "description", length = 25, nullable = false)
	private String description;

	@Column(name = "local_date", length = 25, nullable = false)
	private LocalDateTime time;


	// Relacje

	/**
	 * Relacja pomiędzy Visit a Doctor, dwukierunkowa, wiele do jednego.
	 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;

	/**
	 * Relacja pomiędzy Visit a Patient, dwukierunkowa, wiele do jednego.
	 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	/**
	 * Relacja pomiędzy Visit a MedicalTreatment, dwukierunkowa, jedne do wielu.
	 **/
	@OneToMany(mappedBy = "visitEntity", orphanRemoval = true)
	private Collection<MedicalTreatmentEntity> medicalTreatment;


	// gettery & settery

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
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

	public Collection<MedicalTreatmentEntity> getMedicalTreatment() {
		return medicalTreatment;
	}

	public void setMedicalTreatment(Collection<MedicalTreatmentEntity> medicalTreatment) {
		this.medicalTreatment = medicalTreatment;
	}
}
