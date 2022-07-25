package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Payment;
import com.melcej.home.infratructure.database.entity.PaymentEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentEntityMapper {

  @Autowired
  private BookingEntityMapper bookingEntityMapper;

  @Autowired
  private UserEntityMapper userEntityMapper;

  public Payment toDomain(PaymentEntity paymentEntity){
    if (paymentEntity == null){
      return null;
    }
    return Payment.builder()
        .id(paymentEntity.getId())
        .booking(bookingEntityMapper.toDomain(paymentEntity.getBooking()))
        .user(userEntityMapper.toDomain(paymentEntity.getUser()))
        .amount(paymentEntity.getAmount())
        .method(paymentEntity.getMethod())
        .detail(paymentEntity.getDetail())
        .build();
  }

  public List<Payment> toEntity(List<PaymentEntity> paymentEntities){
    if (paymentEntities == null || paymentEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Payment> payments = new ArrayList<>(paymentEntities.size());
    for (PaymentEntity paymentEntity : paymentEntities){
      payments.add(toDomain(paymentEntity));
    }
    return payments;
  }

  public PaymentEntity toEntity(Payment payment){
    if (payment == null){
      return null;
    }
    return PaymentEntity.builder()
        .id(payment.getId())
        .booking(bookingEntityMapper.toEntity(payment.getBooking()))
        .user(userEntityMapper.toEntity(payment.getUser()))
        .amount(payment.getAmount())
        .method(payment.getMethod())
        .detail(payment.getDetail())
        .build();
  }

}
