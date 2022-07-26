package com.melcej.home.application.repository;

import com.melcej.home.domain.Flight;
import java.util.List;

public interface IFlightRepository {

  Flight add(Flight flight);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Flight> findAllActive();

  Flight findBy(Long id);

  Flight update(Flight flight);

}
