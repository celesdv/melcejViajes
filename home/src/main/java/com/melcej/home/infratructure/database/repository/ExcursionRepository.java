package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IExcursionSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ExcursionRepository {

  private final IExcursionSpringRepository excursionSpringRepository;

}
