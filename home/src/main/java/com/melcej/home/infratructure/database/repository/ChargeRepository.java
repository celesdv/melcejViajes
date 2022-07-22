package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IChargeSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ChargeRepository {

  private final IChargeSpringRepository chargeSpringRepository;

}
