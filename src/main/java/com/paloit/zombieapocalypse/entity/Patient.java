package com.paloit.zombieapocalypse.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PATIENTS_TB")
public class Patient implements Serializable {

  private static final long serialVersionUID = 4900080384684523732L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "ILLNESS")
  private String illness;

  @Column(name = "PAIN")
  private int pain;

  @Column(name = "HOSPITAL")
  private String hospital;

  @Column(name = "PROCESS_TIME")
  private int processTime;

  @Column(name = "PATIENTS")
  private int patients;

  @Column(name ="WAITING_TIME")
  private int waitingTime;


  public Patient(String illness, int pain, String name, int processTime, int patients, int waitingTime) {
    this.illness = illness;
    this.pain = pain;
    this.hospital = name;
    this.processTime = processTime;
    this.patients = patients;
    this.waitingTime = waitingTime;
  }
}
