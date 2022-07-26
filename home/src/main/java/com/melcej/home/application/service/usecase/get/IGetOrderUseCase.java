package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Order;

public interface IGetOrderUseCase {

  Order find(Long id);

}
