package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Hotel;
import com.melcej.home.infratructure.database.entity.HotelEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelEntityMapper {

  @Autowired
  private BudgetEntityMapper budgetEntityMapper;

  @Autowired
  private SupplierEntityMapper supplierEntityMapper;

  public Hotel toDomain(HotelEntity hotelEntity){
    if (hotelEntity == null){
      return null;
    }
    return Hotel.builder()
        .id(hotelEntity.getId())
        .budget(budgetEntityMapper.toDomain(hotelEntity.getBudget()))
        .name(hotelEntity.getName())
        .stay(hotelEntity.getStay())
        .regime(hotelEntity.getRegime())
        .rooms(hotelEntity.getRooms())
        .roomsType(hotelEntity.getRoomsType())
        .supplier(supplierEntityMapper.toDomain(hotelEntity.getSupplier()))
        .value(hotelEntity.getValue())
        .tax(hotelEntity.getTax())
        .detail(hotelEntity.getDetail())
        .build();
  }

  public List<Hotel> toDomain(List<HotelEntity> hotelEntities){
    if (hotelEntities == null || hotelEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Hotel> hotels = new ArrayList<>(hotelEntities.size());
    for (HotelEntity hotelEntity : hotelEntities){
      hotels.add(toDomain(hotelEntity));
    }
    return hotels;
  }

  public HotelEntity toEntity(Hotel hotel){
    if (hotel == null){
      return null;
    }
    return HotelEntity.builder()
        .id(hotel.getId())
        .budget(budgetEntityMapper.toEntity(hotel.getBudget()))
        .name(hotel.getName())
        .stay(hotel.getStay())
        .regime(hotel.getRegime())
        .rooms(hotel.getRooms())
        .roomsType(hotel.getRoomsType())
        .supplier(supplierEntityMapper.toEntity(hotel.getSupplier()))
        .value(hotel.getValue())
        .tax(hotel.getTax())
        .detail(hotel.getDetail())
        .build();
  }

}
