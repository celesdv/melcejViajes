package com.melcej.home.application.repository;

import com.melcej.home.domain.Canned;
import java.util.List;

public interface ICannedRepository {

  Canned add(Canned canned);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Canned> findAllActive();

  Canned findBy(Long id);

  Canned update(Canned canned);

}
