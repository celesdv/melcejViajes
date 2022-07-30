package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Flight;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListFlightUseCase {

  Page<Flight> findAll(PageRequest pageRequest);

}
