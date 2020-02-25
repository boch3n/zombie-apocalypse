package com.paloit.zombieapocalypse.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Illness implements Serializable {

  private static final long serialVersionUID = 6082452024568200812L;

  private String name;

  @NonNull
  private Long id;
}
