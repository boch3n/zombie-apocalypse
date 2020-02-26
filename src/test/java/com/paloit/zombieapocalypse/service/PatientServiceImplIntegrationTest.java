package com.paloit.zombieapocalypse.service;

import com.paloit.zombieapocalypse.entity.Patient;
import com.paloit.zombieapocalypse.repository.PatientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Import(com.paloit.zombieapocalypse.service.PatientService.class)
public class PatientServiceImplIntegrationTest {

  @Autowired
  private PatientService patientService;

  @MockBean
  private PatientRepository patientRepository;

  @Before
  public void setUp() {
    Patient patient = new Patient();
    patient.setId(1L);

    Mockito.when(patientRepository.findById(patient.getId()))
      .thenReturn(Optional.of(patient));
  }

  @Test
  public void whenValidId_thenPatientShouldBeFound() {
    // given
    Long id = 1L;

    // when
    Optional<Patient> found = patientService.getPatientById(id);

    // then
    assertThat(found.get().getId()).isEqualTo(id);
  }


}

