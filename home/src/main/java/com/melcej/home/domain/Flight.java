package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Flight {

  private Long id;
  private Budget budget;
  private String baggage;
  private Supplier supplier;
  private Double value;
  private Double tax;
  private String detail;
  private Boolean softDelete;

}
