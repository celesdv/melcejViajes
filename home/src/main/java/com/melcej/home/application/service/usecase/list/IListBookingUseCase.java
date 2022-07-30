package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Booking;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListBookingUseCase {

  Page<Booking> findAll(PageRequest pageRequest);

}
