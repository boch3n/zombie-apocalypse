package com.paloit.zombieapocalypse.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital implements Serializable {

  private static final long serialVersionUID = -823230006552057599L;

  @NonNull
  private Long id;
  private String name;
  private WaitingList[] waitingLists;
  private Location location;
}
