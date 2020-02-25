package com.paloit.zombieapocalypse.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location implements Serializable {

  private static final long serialVersionUID = 6275204298760631908L;

  private String lat;
  private String lng;
}
