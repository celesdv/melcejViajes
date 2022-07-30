package com.melcej.home.application.repository;

import com.melcej.home.domain.Assistance;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IAssistanceRepository {

  Assistance add(Assistance assistance);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Assistance> findAll(PageRequest pageable);

  List<Assistance> findAllByBudget(Long id);

  Assistance findBy(Long id);

  Assistance update(Assistance assistance);

}
