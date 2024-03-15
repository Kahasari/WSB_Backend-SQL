package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	// Id & zmienne
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "description", length = 25, nullable = false)
	private String description;

	@Column(name = "local_date", length = 25, nullable = false)
	private LocalDateTime time;


	// Relacje

	// Relacja wiele do jednego pomiędzy Visit a Doctor, dwukierunkowa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;

	// Relacja wiele do jednego pomiędzy Visit a Doctor, dwukierunkowa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	// Relacja jeden do wielu pomiędzy Visit a Doctor, jednokierunkowa
	// Czyli w wizycie opisany jest jej typ/przebieg,
	// natomiast sama "agenda" leczenie opisuję jedynie jej przebieg, nie potrzebuję znać daty wykonania.
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	@JoinColumn(name = "visit_id")
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

}
