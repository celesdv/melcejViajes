package com.melcej.home.application.repository;

import com.melcej.home.domain.Order;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IOrderRepository {

  Order add(Order order);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Order> findAll(PageRequest pageRequest);

  Order findBy(Long id);

  Order update(Order order);

}
