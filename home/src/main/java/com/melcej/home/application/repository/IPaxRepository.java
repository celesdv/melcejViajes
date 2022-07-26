package com.melcej.home.application.repository;

import com.melcej.home.domain.Pax;
import java.util.List;

public interface IPaxRepository {

  Pax add(Pax pax);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Pax> findAllActive();

  Pax findBy(Long id);

  Pax update(Pax pax);

}
