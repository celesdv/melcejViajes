package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Payment;
import java.util.List;

public interface IListPaymentUseCase {

  List<Payment> findAll();

}
