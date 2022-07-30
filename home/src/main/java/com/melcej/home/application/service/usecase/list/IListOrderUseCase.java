package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Order;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListOrderUseCase {

  Page<Order> findAll(PageRequest pageRequest);

}
