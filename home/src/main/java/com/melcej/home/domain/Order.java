package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Order {

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String destination;
  private Integer nights;
  private String date;
  private Integer toddler;
  private Integer child;
  private Integer teen;
  private Integer adult;
  private Integer senior;
  private String detail;
  private User user;
  private Boolean softDelete;

}
