package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Charge {

  private Long id;
  private Booking booking;
  private Client client;
  private User user;
  private Double amount;
  private String method;
  private String detail;
  private Boolean softDelete;

}
