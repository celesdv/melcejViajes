package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Client {

  private Long id;
  private String firstName;
  private String lastName;
  private String cuil;
  private String address;
  private String email;
  private String phone;
  private Boolean softDelete;

}
