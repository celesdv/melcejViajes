package com.melcej.home.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Supplier {

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String cbu;
  private Boolean softDelete;

}
