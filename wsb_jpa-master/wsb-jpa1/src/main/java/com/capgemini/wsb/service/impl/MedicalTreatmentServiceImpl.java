package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.MedicalTreatmentTo;
import com.capgemini.wsb.mapper.MedicalTreatmentMapper;
import com.capgemini.wsb.persistence.dao.MedicalTreatmentDao;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.service.MedicalTreatmentService;

import java.util.Collection;
import java.util.stream.Collectors;

public class MedicalTreatmentServiceImpl implements MedicalTreatmentService {
    private final MedicalTreatmentDao medicalTreatmentDao;
    private final MedicalTreatmentMapper medicalTreatmentMapper;

    public MedicalTreatmentServiceImpl(MedicalTreatmentDao medicalTreatmentDao, MedicalTreatmentMapper medicalTreatmentMapper) {
        this.medicalTreatmentDao = medicalTreatmentDao;
        this.medicalTreatmentMapper = medicalTreatmentMapper;
    }

    @Override
    public Collection<MedicalTreatmentTo> showAllTreatments() {
        return medicalTreatmentDao.findAll().stream().map(medicalTreatmentMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public MedicalTreatmentTo getTreatmentWithId(Long id) {
        return medicalTreatmentMapper.mapToTO((MedicalTreatmentEntity) medicalTreatmentDao.getOne(id));
    }

    @Override
    public MedicalTreatmentTo addTreatment(MedicalTreatmentTo medicalTreatmentTo) {
        return medicalTreatmentMapper.mapToTO(medicalTreatmentDao.save(MedicalTreatmentMapper.mapToEntity(medicalTreatmentTo)));
    }

    @Override
    public void removeTreatment(long id) {
        medicalTreatmentDao.delete(id);
    }
}
