package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Booking;
import java.util.List;

public interface IListBookingUseCase {

  List<Booking> findAll();

}
