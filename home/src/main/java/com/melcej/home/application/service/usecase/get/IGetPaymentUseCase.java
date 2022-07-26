package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Payment;

public interface IGetPaymentUseCase {

  Payment find(Long id);

}
