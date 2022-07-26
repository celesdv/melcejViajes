package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Assistance;

public interface IGetAssistanceUseCase {

  Assistance find(Long id);

}
