package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IPaymentSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentRepository {

  private final IPaymentSpringRepository paymentSpringRepository;

}
