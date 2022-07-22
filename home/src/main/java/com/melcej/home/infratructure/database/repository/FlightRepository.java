package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IFlightSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FlightRepository {

  private final IFlightSpringRepository flightSpringRepository;

}
