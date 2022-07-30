package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IFlightRepository;
import com.melcej.home.application.service.usecase.add.ICreateFlightUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteFlightUseCase;
import com.melcej.home.application.service.usecase.get.IGetFlightUseCase;
import com.melcej.home.application.service.usecase.list.IListFlightUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateFlightUseCase;
import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Flight;
import com.melcej.home.domain.Supplier;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class FlightService implements ICreateFlightUseCase, IDeleteFlightUseCase,
    IGetFlightUseCase, IListFlightUseCase, IUpdateFlightUseCase {

  private final IFlightRepository flightRepository;

  @Override
  public Flight add(Flight flight) {
    flight.setSoftDelete(false);
    return flightRepository.add(flight);
  }

  @Override
  public void delete(Long id) {
    if (!flightRepository.existsById(id) || flightRepository.isDeleted(id)){
      throw new RecordNotFoundException("Flight not found");
    }
    flightRepository.delete(id);
  }

  @Override
  public Flight find(@PathVariable Long id) {
    Flight flight = flightRepository.findBy(id);
    if (flight == null || Boolean.TRUE.equals(flight.getSoftDelete())){
      throw new RecordNotFoundException("Flight not found");
    }
    return flight;
  }

  @Override
  public Page<Flight> findAll(PageRequest pageRequest) {
    return flightRepository.findAll(pageRequest);
  }

  @Override
  public Flight update(Flight flightUpdate) {
    Flight flightSaved = find(flightUpdate.getId());
    flightSaved.setSoftDelete(false);
    updateValues(flightSaved, flightUpdate);
    return flightRepository.update(flightSaved);
  }

  private void updateValues(Flight flightSaved, Flight flightUpdate) {
    Budget budget = flightUpdate.getBudget();
    if (budget != null){
      flightSaved.setBudget(budget);
    }

    String baggage = flightUpdate.getBaggage();
    if (baggage != null){
      flightSaved.setBaggage(baggage);
    }

    Supplier supplier = flightUpdate.getSupplier();
    if (supplier != null){
      flightSaved.setSupplier(supplier);
    }

    Double value = flightUpdate.getValue();
    if (value != null){
      flightSaved.setValue(value);
    }

    Double tax = flightUpdate.getTax();
    if (tax != null){
      flightSaved.setTax(tax);
    }

    String detail = flightUpdate.getDetail();
    if (detail != null){
      flightSaved.setDetail(detail);
    }
  }
}
