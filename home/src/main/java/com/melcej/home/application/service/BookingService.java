package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IBookingRepository;
import com.melcej.home.application.service.usecase.add.ICreateBookingUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteBookingUseCase;
import com.melcej.home.application.service.usecase.get.IGetBookingUseCase;
import com.melcej.home.application.service.usecase.list.IListBookingUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateBookingUseCase;
import com.melcej.home.domain.Booking;
import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Client;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class BookingService implements ICreateBookingUseCase, IDeleteBookingUseCase,
    IGetBookingUseCase, IListBookingUseCase, IUpdateBookingUseCase {

  private final IBookingRepository bookingRepository;

  @Override
  public Booking add(Booking booking) {
    booking.setSoftDelete(false);
    return bookingRepository.add(booking);
  }

  @Override
  public void delete(Long id) {
    if (!bookingRepository.existsById(id) || bookingRepository.isDeleted(id)){
      throw new RecordNotFoundException("Booking not found.");
    }
    bookingRepository.delete(id);
  }

  @Override
  public Booking find(@PathVariable Long id) {
    Booking booking = bookingRepository.findBy(id);
    if (booking == null || Boolean.TRUE.equals(booking.getSoftDelete())){
      throw new RecordNotFoundException("Booking not found.");
    }
    return booking;
  }

  @Override
  public Page<Booking> findAll(PageRequest pageRequest) {
    return bookingRepository.findAll(pageRequest);
  }

  @Override
  public Booking update(Booking bookingUpdate) {
    Booking bookingSaved = find(bookingUpdate.getId());
    bookingSaved.setSoftDelete(false);
    updateValues(bookingSaved, bookingUpdate);
    return bookingRepository.update(bookingSaved);
  }

  private void updateValues(Booking bookingSaved, Booking bookingUpdate) {
    Budget budget = bookingUpdate.getBudget();
    if (budget != null){
      bookingSaved.setBudget(budget);
    }

    Client holder = bookingUpdate.getHolder();
    if (holder != null){
      bookingSaved.setHolder(holder);
    }

    String detail = bookingUpdate.getDetail();
    if (detail != null){
      bookingSaved.setDetail(detail);
    }
  }


}
