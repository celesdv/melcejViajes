package com.melcej.home.application.repository;

import com.melcej.home.domain.Hotel;
import java.util.List;

public interface IHotelRepository {

  Hotel add(Hotel hotel);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Hotel> findAllActive();

  Hotel findBy(Long id);

  Hotel update(Hotel hotel);

}
