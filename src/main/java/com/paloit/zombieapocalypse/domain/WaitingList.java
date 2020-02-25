package com.paloit.zombieapocalypse.domain;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaitingList implements Serializable {

  private static final long serialVersionUID = -2633257316122618920L;

  private int patientCount;
  private int levelOfPain;
  private int averageProcessTime;
}
