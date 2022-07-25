package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Order;
import com.melcej.home.infratructure.database.entity.OrderEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {

  @Autowired
  private UserEntityMapper userEntityMapper;

  public Order toDomain(OrderEntity orderEntity){
    if (orderEntity == null){
      return null;
    }
    return Order.builder()
        .id(orderEntity.getId())
        .name(orderEntity.getName())
        .email(orderEntity.getEmail())
        .phone(orderEntity.getPhone())
        .destination(orderEntity.getDestination())
        .nights(orderEntity.getNights())
        .date(orderEntity.getDate())
        .toddler(orderEntity.getToddler())
        .child(orderEntity.getChild())
        .teen(orderEntity.getTeen())
        .adult(orderEntity.getAdult())
        .senior(orderEntity.getSenior())
        .id(orderEntity.getId())
        .name(orderEntity.getName())
        .email(orderEntity.getEmail())
        .phone(orderEntity.getPhone())
        .destination(orderEntity.getDestination())
        .nights(orderEntity.getNights())
        .date(orderEntity.getDate())
        .toddler(orderEntity.getToddler())
        .child(orderEntity.getChild())
        .teen(orderEntity.getTeen())
        .adult(orderEntity.getAdult())
        .senior(orderEntity.getSenior())
        .user(userEntityMapper.toDomain(orderEntity.getUser()))
        .build();
  }

  public List<Order> toDomain(List<OrderEntity> orderEntities){
    if (orderEntities == null || orderEntities.isEmpty()) {
      return Collections.emptyList();
    }
    List<Order> orders = new ArrayList<>(orderEntities.size());
    for (OrderEntity orderEntity : orderEntities) {
      orders.add(toDomain(orderEntity));
    }
    return orders;
  }

  public OrderEntity toEntity(Order order){
    if (order == null){
      return null;
    }
    return OrderEntity.builder()
        .id(order.getId())
        .name(order.getName())
        .email(order.getEmail())
        .phone(order.getPhone())
        .destination(order.getDestination())
        .nights(order.getNights())
        .date(order.getDate())
        .toddler(order.getToddler())
        .child(order.getChild())
        .teen(order.getTeen())
        .adult(order.getAdult())
        .senior(order.getSenior())
        .user(userEntityMapper.toEntity(order.getUser()))
        .build();
  }

}
