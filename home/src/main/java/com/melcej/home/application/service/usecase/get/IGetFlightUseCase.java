package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Flight;

public interface IGetFlightUseCase {

  Flight find(Long id);

}
