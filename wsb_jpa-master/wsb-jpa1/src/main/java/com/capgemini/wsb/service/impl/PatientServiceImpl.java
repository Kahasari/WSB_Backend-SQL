package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientDao patientDao, PatientMapper patientMapper) {
        this.patientDao = patientDao;
        this.patientMapper = patientMapper;
    }

    @Override
    public Collection<PatientTO> showPatients() {
        return patientDao.findAll().stream().map(patientMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public PatientTO getPatientWithId(Long id) {
        return patientMapper.mapToTO(patientDao.getOne(id));
    }

    @Override
    public PatientTO addPatient(PatientTO patientTO) {
        return patientMapper.mapToTO(patientDao.save(PatientMapper.mapToEntity(patientTO)));
    }

    @Override
    public void removePatient(Long id) {
        patientDao.delete(id);
    }
}