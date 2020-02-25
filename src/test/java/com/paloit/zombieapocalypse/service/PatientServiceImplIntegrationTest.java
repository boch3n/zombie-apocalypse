package com.paloit.zombieapocalypse.service;


import com.paloit.zombieapocalypse.repository.PatientRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PatientServiceImplIntegrationTest {


    @Autowired
    private PatientService patientService;

    @MockBean
    private PatientRepository patientRepository;

    // write test cases here
  }

