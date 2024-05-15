package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import javax.persistence.*;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	// Id & zmienne //
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description", length = 300,nullable = false)
	private String description;

	// Relacje //
	/**
	 * Relacja między MedicalTreatment a Visit, wiele do jednego.
	 **/
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_id")
	private VisitEntity visitEntity; // relacja dwustronna

	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	// gettery & settery //

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

	public VisitEntity getVisitEntity() {
		return visitEntity;
	}

	public void setVisitEntity(VisitEntity visitEntity) {
		this.visitEntity = visitEntity;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}
}
