package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Payment {

  private Long id;
  private Booking booking;
  private User user;
  private Double amount;
  private String method;
  private String detail;
  private Boolean softDelete;

}
