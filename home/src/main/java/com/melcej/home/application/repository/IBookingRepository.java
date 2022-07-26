package com.melcej.home.application.repository;

import com.melcej.home.domain.Booking;
import java.util.List;

public interface IBookingRepository {

  Booking add(Booking booking);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Booking> findAllActive();

  Booking findBy(Long id);

  Booking  update(Booking booking);

}
