package com.paloit.zombieapocalypse.controller;

import com.paloit.zombieapocalypse.entity.Patient;
import com.paloit.zombieapocalypse.service.PatientService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {

  private PatientService patientService;

  @Inject
  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @GetMapping("/patients")
  private List<Patient> getAllPatients() {
    return patientService.getAllPatients();
  }

  @GetMapping("/patients/{id}")
  private Patient getPatient(@PathVariable("id") Long id) {
    return patientService.getPatientById(id);
  }

  @DeleteMapping("/patients/{id}")
  private void deletePatient(@PathVariable("id") Long id) {
    patientService.delete(id);
  }

  @PostMapping("/patients")
  private Long savePatient(@RequestBody Patient patient) {
    this.patientService.saveOrUpdate(patient);
    return patient.getId();
  }

}
