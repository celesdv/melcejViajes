package com.melcej.home.application.repository;

import com.melcej.home.domain.Order;
import java.util.List;

public interface IOrderRepository {

  Order add(Order order);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Order> findAllActive();

  Order findBy(Long id);

  Order update(Order order);

}
