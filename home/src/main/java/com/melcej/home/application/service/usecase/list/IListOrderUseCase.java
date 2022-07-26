package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Order;
import java.util.List;

public interface IListOrderUseCase {

  List<Order> findAll();

}
