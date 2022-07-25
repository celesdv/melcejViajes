package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Pax;
import com.melcej.home.infratructure.database.entity.PaxEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaxEntityMapper {

  @Autowired
  private BookingEntityMapper bookingEntityMapper;

  public Pax toDomain(PaxEntity paxEntity){
    if (paxEntity == null){
      return null;
    }
    return Pax.builder()
        .id(paxEntity.getId())
        .booking(bookingEntityMapper.toDomain(paxEntity.getBooking()))
        .firstName(paxEntity.getFirstName())
        .lastName(paxEntity.getLastName())
        .dni(paxEntity.getDni())
        .passport(paxEntity.getPassport())
        .passportExpiration(paxEntity.getPassportExpiration())
        .birthDate(paxEntity.getBirthDate())
        .build();
  }

  public List<Pax> toDomain(List<PaxEntity> paxEntities){
    if (paxEntities == null || paxEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Pax> pax = new ArrayList<>(paxEntities.size());
    for (PaxEntity paxEntity : paxEntities){
      pax.add(toDomain(paxEntity));
    }
    return pax;
  }

  public PaxEntity toEntity(Pax pax){
    if (pax == null){
      return null;
    }
    return PaxEntity.builder()
        .id(pax.getId())
        .booking(bookingEntityMapper.toEntity(pax.getBooking()))
        .firstName(pax.getFirstName())
        .lastName(pax.getLastName())
        .dni(pax.getDni())
        .passport(pax.getPassport())
        .passportExpiration(pax.getPassportExpiration())
        .birthDate(pax.getBirthDate())
        .build();
  }

}
