package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Charge;

public interface IGetChargeUseCase {

  Charge find(Long id);

}
