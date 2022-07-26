package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Excursion;

public interface IGetExcursionUseCase {

  Excursion find(Long id);

}
