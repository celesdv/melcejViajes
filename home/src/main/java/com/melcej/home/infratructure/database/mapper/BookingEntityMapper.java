package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Booking;
import com.melcej.home.infratructure.database.entity.BookingEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingEntityMapper {

  @Autowired
  private BudgetEntityMapper budgetEntityMapper;

  @Autowired
  private ClientEntityMapper clientEntityMapper;

  public Booking toDomain(BookingEntity bookingEntity){
    if (bookingEntity == null){
      return null;
    }
    return Booking.builder()
        .id(bookingEntity.getId())
        .budget(budgetEntityMapper.toDomain(bookingEntity.getBudget()))
        .holder(clientEntityMapper.toDomain(bookingEntity.getHolder()))
        .detail(bookingEntity.getDetail())
        .build();
  }

  public List<Booking> toDomain(List<BookingEntity> bookingEntities){
    if (bookingEntities == null || bookingEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Booking> bookings = new ArrayList<>(bookingEntities.size());
    for (BookingEntity bookingEntity : bookingEntities){
      bookings.add(toDomain(bookingEntity));
    }
    return bookings;
  }

  public BookingEntity toEntity(Booking booking){
    if (booking == null){
      return null;
    }
    return BookingEntity.builder()
        .id(booking.getId())
        .budget(budgetEntityMapper.toEntity(booking.getBudget()))
        .holder(clientEntityMapper.toEntity(booking.getHolder()))
        .detail(booking.getDetail())
        .build();
  }

}
