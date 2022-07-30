package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IHotelRepository;
import com.melcej.home.application.service.usecase.add.ICreateHotelUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteHotelUseCase;
import com.melcej.home.application.service.usecase.get.IGetHotelUseCase;
import com.melcej.home.application.service.usecase.list.IListHotelUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateHotelUseCase;
import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Hotel;
import com.melcej.home.domain.Supplier;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class HotelService implements ICreateHotelUseCase, IDeleteHotelUseCase, IGetHotelUseCase,
    IListHotelUseCase, IUpdateHotelUseCase {

  private final IHotelRepository hotelRepository;

  @Override
  public Hotel add(Hotel hotel) {
    hotel.setSoftDelete(false);
    return hotelRepository.add(hotel);
  }

  @Override
  public void delete(Long id) {
    if (!hotelRepository.existsById(id) || hotelRepository.isDeleted(id)){
      throw new RecordNotFoundException("Hotel not found");
    }
    hotelRepository.delete(id);
  }

  @Override
  public Hotel find(@PathVariable Long id) {
    Hotel hotel = hotelRepository.findBy(id);
    if (hotel == null || Boolean.TRUE.equals(hotel.getSoftDelete())){
      throw new RecordNotFoundException("Hotel not found");
    }
    return hotel;
  }

  @Override
  public Page<Hotel> findAll(PageRequest pageRequest) {
    return hotelRepository.findAll(pageRequest);
  }

  @Override
  public List<Hotel> findAllByBudget(Long id) {
    return hotelRepository.findAllByBudget(id);
  }

  @Override
  public Hotel update(Hotel hotelUpdate) {
    Hotel hotelSaved = find(hotelUpdate.getId());
    hotelSaved.setSoftDelete(false);
    updateValues(hotelSaved, hotelUpdate);
    return hotelRepository.update(hotelSaved);
  }

  private void updateValues(Hotel hotelSaved, Hotel hotelUpdate) {
    Budget budget = hotelUpdate.getBudget();
    if (budget != null){
      hotelSaved.setBudget(budget);
    }

    String name = hotelUpdate.getName();
    if (name != null){
      hotelSaved.setName(name);
    }

    String stay = hotelUpdate.getStay();
    if (stay != null){
      hotelSaved.setStay(stay);
    }

    String regime = hotelUpdate.getRegime();
    if (regime != null){
      hotelSaved.setRegime(regime);
    }

    Integer rooms = hotelUpdate.getRooms();
    if (rooms != null){
      hotelSaved.setRooms(rooms);
    }

    String roomType = hotelUpdate.getRoomsType();
    if (roomType != null){
      hotelSaved.setRoomsType(roomType);
    }

    Supplier supplier = hotelUpdate.getSupplier();
    if (supplier != null){
      hotelSaved.setSupplier(supplier);
    }

    Double value = hotelUpdate.getValue();
    if (value != null){
      hotelSaved.setValue(value);
    }

    Double tax = hotelUpdate.getTax();
    if (tax != null){
      hotelSaved.setTax(tax);
    }

    String detail = hotelUpdate.getDetail();
    if (detail != null){
      hotelSaved.setDetail(detail);
    }
  }
}
