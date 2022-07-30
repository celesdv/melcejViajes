package com.melcej.home.application.repository;

import com.melcej.home.domain.Supplier;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ISupplierRepository {

  Supplier add(Supplier supplier);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Supplier> findAll(PageRequest pageRequest);

  Supplier findBy(Long id);

  Supplier update(Supplier supplier);

}
