package com.melcej.home.application.repository;

import com.melcej.home.domain.Excursion;
import java.util.List;

public interface IExcursionRepository {

  Excursion add(Excursion excursion);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Excursion> findAllActive();

  Excursion findBy(Long id);

  Excursion update(Excursion excursion);

}
