package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IClientSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClientRepository {

  private final IClientSpringRepository clientSpringRepository;

}
