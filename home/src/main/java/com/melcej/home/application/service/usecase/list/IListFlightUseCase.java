package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Flight;
import java.util.List;

public interface IListFlightUseCase {

  List<Flight> findAll();

}
