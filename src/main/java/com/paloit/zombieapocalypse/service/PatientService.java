package com.paloit.zombieapocalypse.service;

import com.paloit.zombieapocalypse.entity.Patient;
import com.paloit.zombieapocalypse.repository.PatientRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

  private PatientRepository patientRepository;

  @Inject
  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  public PatientService() {
  }

  public List<Patient> getAllPatients() {
    return new ArrayList<>(patientRepository.findAll());
  }

  public Optional<Patient> getPatientById(Long id) {
    return patientRepository.findById(id);
  }

  public void saveOrUpdate(Patient patient) {
    patientRepository.save(patient);

  }

  public void delete(Long id) {
    patientRepository.deleteById(id);
  }

}
