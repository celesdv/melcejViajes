package com.melcej.home.application.repository;

import com.melcej.home.domain.Flight;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IFlightRepository {

  Flight add(Flight flight);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Flight> findAll(PageRequest pageRequest);

  List<Flight> findAllByBudget(Long id);

  Flight findBy(Long id);

  Flight update(Flight flight);

}
