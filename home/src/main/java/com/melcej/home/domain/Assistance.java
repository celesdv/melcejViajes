package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Assistance {

  private Long id;
  private Budget budget;
  private String type;
  private Supplier supplier;
  private Double value;
  private Double tax;
  private String detail;
  private Boolean softDelete;

}
