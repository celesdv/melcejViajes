package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Hotel;

public interface IGetHotelUseCase {

  Hotel find(Long id);

}
