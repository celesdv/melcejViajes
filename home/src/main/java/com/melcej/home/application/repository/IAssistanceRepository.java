package com.melcej.home.application.repository;

import com.melcej.home.domain.Assistance;
import java.util.List;

public interface IAssistanceRepository {

  Assistance add(Assistance assistance);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Assistance> findAllActive();

  Assistance findBy(Long id);

  Assistance update(Assistance assistance);

}
