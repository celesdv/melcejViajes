package com.melcej.home.application.repository;

import com.melcej.home.domain.Budget;
import java.util.List;

public interface IBudgetRepository {

  Budget add(Budget budget);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Budget> findAllActive();

  Budget findBy(Long id);

  Budget update(Budget budget);

}
