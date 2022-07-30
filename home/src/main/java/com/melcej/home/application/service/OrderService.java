package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IOrderRepository;
import com.melcej.home.application.service.usecase.add.ICreateOrderUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteOrderUseCase;
import com.melcej.home.application.service.usecase.get.IGetOrderUseCase;
import com.melcej.home.application.service.usecase.list.IListOrderUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateOrderUseCase;
import com.melcej.home.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class OrderService implements ICreateOrderUseCase, IDeleteOrderUseCase, IGetOrderUseCase,
    IListOrderUseCase, IUpdateOrderUseCase {

  private final IOrderRepository orderRepository;
  
  @Override
  public Order add(Order order) {
    order.setSoftDelete(false);
    return orderRepository.add(order);
  }

  @Override
  public void delete(Long id) {
    if (!orderRepository.existsById(id) || orderRepository.isDeleted(id)){
      throw new RecordNotFoundException("Order not found");
    }
    orderRepository.delete(id);
  }

  @Override
  public Order find(@PathVariable Long id) {
    Order order = orderRepository.findBy(id);
    if (order == null || Boolean.TRUE.equals(order.getSoftDelete())){
      throw new RecordNotFoundException("Order not found");
    }
    return order;
  }

  @Override
  public Page<Order> findAll(PageRequest pageRequest) {
    return orderRepository.findAll(pageRequest);
    // TODO: 30/7/2022 search by soft delete
  }

  @Override
  public Order update(Order orderUpdate) {
    Order orderSaved = find(orderUpdate.getId());
    orderSaved.setSoftDelete(false);
    updateValueData(orderSaved, orderUpdate);
    updateValueDetail(orderSaved, orderUpdate);
    return orderRepository.update(orderSaved);
  }

  private void updateValueData(Order orderSaved, Order orderUpdate) {
    String name = orderUpdate.getName();
    if (name != null){
      orderSaved.setName(name);
    }

    String email = orderUpdate.getEmail();
    if (email != null){
      orderSaved.setEmail(email);
    }

    String phone = orderUpdate.getPhone();
    if (phone != null){
      orderSaved.setPhone(phone);
    }

    String destination = orderUpdate.getDestination();
    if (destination != null){
      orderSaved.setDestination(destination);
    }

    String date = orderUpdate.getDate();
    if (date != null){
      orderSaved.setDate(date);
    }

    Integer nights = orderUpdate.getNights();
    if (nights != null){
      orderSaved.setNights(nights);
    }
  }

  private void updateValueDetail(Order orderSaved, Order orderUpdate) {
    Integer toddler = orderUpdate.getToddler();
    if (toddler != null){
      orderSaved.setToddler(toddler);
    }

    Integer child = orderUpdate.getChild();
    if (child != null){
      orderSaved.setChild(child);
    }

    Integer teen = orderUpdate.getTeen();
    if (teen != null){
      orderSaved.setTeen(teen);
    }

    Integer adult = orderUpdate.getAdult();
    if (adult != null){
      orderSaved.setAdult(adult);
    }

    Integer senior = orderUpdate.getSenior();
    if (senior != null){
      orderSaved.setSenior(senior);
    }

    String detail = orderUpdate.getDetail();
    if (detail != null){
      orderSaved.setDetail(detail);
    }
  }
}
