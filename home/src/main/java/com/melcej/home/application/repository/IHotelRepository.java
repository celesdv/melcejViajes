package com.melcej.home.application.repository;

import com.melcej.home.domain.Hotel;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IHotelRepository {

  Hotel add(Hotel hotel);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Hotel> findAll(PageRequest pageRequest);

  Hotel findBy(Long id);

  Hotel update(Hotel hotel);

}
