package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Payment;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListPaymentUseCase {

  Page<Payment> findAll(PageRequest pageRequest);

}
