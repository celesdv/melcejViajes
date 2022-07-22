package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.ITransferSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransferRepository {

  private final ITransferSpringRepository transferSpringRepository;

}
