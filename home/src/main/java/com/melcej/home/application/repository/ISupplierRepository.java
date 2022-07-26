package com.melcej.home.application.repository;

import com.melcej.home.domain.Supplier;
import java.util.List;

public interface ISupplierRepository {

  Supplier add(Supplier supplier);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Supplier> findAllActive();

  Supplier findBy(Long id);

  Supplier update(Supplier supplier);

}
