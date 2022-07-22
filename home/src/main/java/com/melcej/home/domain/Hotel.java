package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Hotel {

  private Long id;
  private Budget budget;
  private String name;
  private String stay;
  private String regime;
  private Integer rooms;
  private String roomsType;
  private Supplier supplier;
  private Double value;
  private Double tax;
  private String detail;
  private Boolean softDelete;

}
