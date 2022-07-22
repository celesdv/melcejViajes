package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IOrderSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderRepository {

  private final IOrderSpringRepository orderSpringRepository;

}
