package com.melcej.home.application.repository;

import com.melcej.home.domain.Payment;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IPaymentRepository {

  Payment add(Payment payment);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Payment> findAll(PageRequest pageRequest);

  Payment findBy(Long id);

  Payment update(Payment payment);

}
