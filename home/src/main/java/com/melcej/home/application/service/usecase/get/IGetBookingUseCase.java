package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Booking;

public interface IGetBookingUseCase {

  Booking find(Long id);

}
