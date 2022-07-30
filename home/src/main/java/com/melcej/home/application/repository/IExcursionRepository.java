package com.melcej.home.application.repository;

import com.melcej.home.domain.Excursion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IExcursionRepository {

  Excursion add(Excursion excursion);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Excursion> findAll(PageRequest pageRequest);

  Excursion findBy(Long id);

  Excursion update(Excursion excursion);

}
