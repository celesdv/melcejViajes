package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IRoleSpringRepository;
import com.melcej.home.infratructure.database.repository.spring.IUserSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserRepository {

  private final IUserSpringRepository userSpringRepository;
  private final IRoleSpringRepository roleSpringRepository;

}
