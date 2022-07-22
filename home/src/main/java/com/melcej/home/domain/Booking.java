package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Booking {

  private Long id;
  private Budget budget;
  private Client holder;
  private String detail;
  private Boolean softDelete;

}
