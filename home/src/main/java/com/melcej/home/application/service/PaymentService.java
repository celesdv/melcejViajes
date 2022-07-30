package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IPaymentRepository;
import com.melcej.home.application.service.usecase.add.ICreatePaymentUseCase;
import com.melcej.home.application.service.usecase.delete.IDeletePaymentUseCase;
import com.melcej.home.application.service.usecase.get.IGetPaymentUseCase;
import com.melcej.home.application.service.usecase.list.IListPaymentUseCase;
import com.melcej.home.application.service.usecase.update.IUpdatePaymentUseCase;
import com.melcej.home.domain.Booking;
import com.melcej.home.domain.Client;
import com.melcej.home.domain.Payment;
import com.melcej.home.domain.User;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class PaymentService implements ICreatePaymentUseCase, IDeletePaymentUseCase,
    IGetPaymentUseCase, IListPaymentUseCase, IUpdatePaymentUseCase {

  private final IPaymentRepository paymentRepository;

  @Override
  public Payment add(Payment payment) {
    payment.setSoftDelete(false);
    return paymentRepository.add(payment);
  }

  @Override
  public void delete(Long id) {
    if (!paymentRepository.existsById(id) || paymentRepository.isDeleted(id)){
      throw new RecordNotFoundException("Payment not found");
    }
    paymentRepository.delete(id);
  }

  @Override
  public Payment find(@PathVariable Long id) {
    Payment payment = paymentRepository.findBy(id);
    if (payment == null || Boolean.TRUE.equals(payment.getSoftDelete())){
      throw new RecordNotFoundException("Payment not found");
    }
    return payment;
  }

  @Override
  public Page<Payment> findAll(PageRequest pageRequest) {
    return paymentRepository.findAll(pageRequest);
  }

  @Override
  public Payment update(Payment paymentUpdate) {
    Payment paymentSaved = find(paymentUpdate.getId());
    paymentSaved.setSoftDelete(false);
    updateValue(paymentSaved, paymentUpdate);
    return paymentRepository.update(paymentSaved);
  }

  private void updateValue(Payment paymentSaved, Payment paymentUpdate) {
    Booking booking = paymentUpdate.getBooking();
    if (booking != null){
      paymentSaved.setBooking(booking);
    }

    User user = paymentUpdate.getUser();
    if (user != null){
      paymentSaved.setUser(user);
    }

    Double amount = paymentUpdate.getAmount();
    if (amount != null){
      paymentSaved.setAmount(amount);
    }

    String method = paymentUpdate.getMethod();
    if (method != null){
      paymentSaved.setMethod(method);
    }

    String detail = paymentUpdate.getDetail();
    if (detail != null){
      paymentSaved.setDetail(detail);
    }
  }
}
