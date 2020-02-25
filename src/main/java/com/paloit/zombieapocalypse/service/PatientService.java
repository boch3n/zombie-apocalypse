package com.paloit.zombieapocalypse.service;

import com.paloit.zombieapocalypse.entity.Patient;
import com.paloit.zombieapocalypse.repository.PatientRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

  private PatientRepository patientRepository;

  @Inject
  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  public List<Patient> getAllPatients() {
    return new ArrayList<>(patientRepository.findAll());
  }

  public Patient getPatientById(Long id) {
    return patientRepository.findById(id).get();
  }

  public void saveOrUpdate(Patient patient) {
    patientRepository.save(patient);

  }

  public void delete(Long id) {
    patientRepository.deleteById(id);
  }

}
