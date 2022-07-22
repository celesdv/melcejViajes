package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IPaxSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaxRepository {

  private final IPaxSpringRepository paxSpringRepository;

}
