package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Supplier;

public interface IGetSupplierUseCase {

  Supplier find(Long id);

}
