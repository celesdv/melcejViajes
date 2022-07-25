package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Charge;
import com.melcej.home.infratructure.database.entity.ChargeEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChargeEntityMapper {

  @Autowired
  private BookingEntityMapper bookingEntityMapper;

  @Autowired
  private ClientEntityMapper clientEntityMapper;

  @Autowired
  private UserEntityMapper userEntityMapper;

  public Charge toDomain(ChargeEntity chargeEntity){
    if (chargeEntity == null){
      return null;
    }
    return Charge.builder()
        .id(chargeEntity.getId())
        .booking(bookingEntityMapper.toDomain(chargeEntity.getBooking()))
        .client(clientEntityMapper.toDomain(chargeEntity.getClient()))
        .user(userEntityMapper.toDomain(chargeEntity.getUser()))
        .amount(chargeEntity.getAmount())
        .method(chargeEntity.getMethod())
        .detail(chargeEntity.getDetail())
        .build();
  }

  public List<Charge> toEntity(List<ChargeEntity> chargeEntities){
    if (chargeEntities == null || chargeEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Charge> charges = new ArrayList<>(chargeEntities.size());
    for (ChargeEntity chargeEntity : chargeEntities){
      charges.add(toDomain(chargeEntity));
    }
    return charges;
  }

  public ChargeEntity toEntity(Charge charge){
    if (charge == null){
      return null;
    }
    return ChargeEntity.builder()
        .id(charge.getId())
        .booking(bookingEntityMapper.toEntity(charge.getBooking()))
        .client(clientEntityMapper.toEntity(charge.getClient()))
        .user(userEntityMapper.toEntity(charge.getUser()))
        .amount(charge.getAmount())
        .method(charge.getMethod())
        .detail(charge.getDetail())
        .build();
  }

}
