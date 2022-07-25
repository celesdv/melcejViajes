package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Flight;
import com.melcej.home.infratructure.database.entity.FlightEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightEntityMapper {

  @Autowired
  private BudgetEntityMapper budgetEntityMapper;

  @Autowired
  private SupplierEntityMapper supplierEntityMapper;

  public Flight toDomain(FlightEntity flightEntity){
    if (flightEntity == null){
      return null;
    }
    return Flight.builder()
        .id(flightEntity.getId())
        .budget(budgetEntityMapper.toDomain(flightEntity.getBudget()))
        .baggage(flightEntity.getBaggage())
        .supplier(supplierEntityMapper.toDomain(flightEntity.getSupplier()))
        .value(flightEntity.getValue())
        .tax(flightEntity.getTax())
        .detail(flightEntity.getDetail())
        .build();
  }

  public List<Flight> toDomain(List<FlightEntity> flightEntities){
    if (flightEntities == null || flightEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Flight> flights = new ArrayList<>(flightEntities.size());
    for (FlightEntity flightEntity : flightEntities){
      flights.add(toDomain(flightEntity));
    }
    return flights;
  }

  public FlightEntity toEntity(Flight flight){
    if (flight == null){
      return null;
    }
    return FlightEntity.builder()
        .id(flight.getId())
        .budget(budgetEntityMapper.toEntity(flight.getBudget()))
        .baggage(flight.getBaggage())
        .supplier(supplierEntityMapper.toEntity(flight.getSupplier()))
        .value(flight.getValue())
        .tax(flight.getTax())
        .detail(flight.getDetail())
        .build();
  }

}
