package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Pax;

public interface IGetPaxUseCase {

  Pax find(Long id);

}
