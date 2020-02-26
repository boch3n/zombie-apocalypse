package com.paloit.zombieapocalypse.controller;

import com.paloit.zombieapocalypse.entity.Patient;
import com.paloit.zombieapocalypse.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PatientController.class)
public class PatientControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private PatientService service;

  @Test
  public void givenPatients_whenGetPatient_thenReturnJsonArray()
    throws Exception {

    Patient patient = new Patient();

    List<Patient> allPatients = Collections.singletonList(patient);

    given(service.getAllPatients()).willReturn(allPatients);

    mvc.perform(get("/patients")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$", hasSize(1)))
      .andExpect(jsonPath("$[0].id", is(patient.getId())));
  }
}

