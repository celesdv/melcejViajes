package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IHotelSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HotelRepository {

  private final IHotelSpringRepository hotelSpringRepository;

}
