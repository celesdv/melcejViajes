package com.melcej.home.application.repository;

import com.melcej.home.domain.Payment;
import java.util.List;

public interface IPaymentRepository {

  Payment add(Payment payment);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Payment> findAllActive();

  Payment findBy(Long id);

  Payment update(Payment payment);

}
