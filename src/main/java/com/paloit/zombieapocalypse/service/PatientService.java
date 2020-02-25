package com.paloit.zombieapocalypse.service;

import com.paloit.zombieapocalypse.domain.Hospital;
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
//    int averageProcessTime = hospital.getWaitingLists()[0].getAverageProcessTime();
//    int patientCount = hospital.getWaitingLists()[0].getPatientCount();
//    int waitingTime = averageProcessTime * patientCount;
//    Patient patient = new Patient(pain, hospital.getName(), averageProcessTime, patientCount, waitingTime);

    patientRepository.save(patient);

  }

  public void delete(Long id) {
    patientRepository.deleteById(id);
  }

  public void addPatient(int pain, Hospital hospital) {


  }

}
