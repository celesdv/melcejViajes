package com.melcej.home.application.repository;

import com.melcej.home.domain.Budget;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IBudgetRepository {

  Budget add(Budget budget);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Budget> findAll(PageRequest pageRequest);

  Budget findBy(Long id);

  Budget update(Budget budget);

}
