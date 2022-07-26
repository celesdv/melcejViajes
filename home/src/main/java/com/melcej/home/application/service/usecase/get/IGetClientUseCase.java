package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Client;

public interface IGetClientUseCase {

  Client find(Long id);

}
