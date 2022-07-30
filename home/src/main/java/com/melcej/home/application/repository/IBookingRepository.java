package com.melcej.home.application.repository;

import com.melcej.home.domain.Booking;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IBookingRepository {

  Booking add(Booking booking);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Booking> findAll(PageRequest pageRequest);

  Booking findBy(Long id);

  Booking  update(Booking booking);

}
