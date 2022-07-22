package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.ISupplierSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SupplierRepository {

  private final ISupplierSpringRepository supplierSpringRepository;

}
