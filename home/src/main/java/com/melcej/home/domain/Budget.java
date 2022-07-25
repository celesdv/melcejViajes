package com.melcej.home.domain;

import com.melcej.home.infratructure.database.entity.OrderEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Budget {

  private Long id;
  private Order order;
  private String detail;
  private Double totalPrice;
  private Boolean softDelete;

}
