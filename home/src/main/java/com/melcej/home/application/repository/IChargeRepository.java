package com.melcej.home.application.repository;

import com.melcej.home.domain.Charge;
import java.util.List;

public interface IChargeRepository {

  Charge add(Charge charge);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Charge> findAllActive();

  Charge findBy(Long id);

  Charge update(Charge charge);

}
