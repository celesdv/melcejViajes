package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.ICannedSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CannedRepository {

  private final ICannedSpringRepository cannedSpringRepository;

}
