package com.paloit.zombieapocalypse.repository;

import com.paloit.zombieapocalypse.entity.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientRepositoryIntegrationTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private PatientRepository patientRepository;

  @Test
  public void whenFindById_thenReturnPatient() {
    // given
    Patient patient = new Patient();
    entityManager.persist(patient);
    entityManager.flush();

    // when
    Optional<Patient> found = patientRepository.findById(patient.getId());

    // then
    assertThat(found.get().getId()).isEqualTo(patient.getId());
  }

}

