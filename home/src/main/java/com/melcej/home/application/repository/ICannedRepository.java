package com.melcej.home.application.repository;

import com.melcej.home.domain.Canned;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ICannedRepository {

  Canned add(Canned canned);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Canned> findAll(PageRequest pageRequest);

  List<Canned> findAllByBudget(Long id);

  Canned findBy(Long id);

  Canned update(Canned canned);

}
