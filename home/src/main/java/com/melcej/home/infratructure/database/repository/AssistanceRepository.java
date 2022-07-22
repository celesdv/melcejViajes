package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IAssistanceSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AssistanceRepository {

  private final IAssistanceSpringRepository assistanceSpringRepository;

}
