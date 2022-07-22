package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IBookingSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookingRepository {

  private final IBookingSpringRepository bookingSpringRepository;

}
