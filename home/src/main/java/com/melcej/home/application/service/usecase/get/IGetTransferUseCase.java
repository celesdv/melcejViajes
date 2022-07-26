package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Transfer;

public interface IGetTransferUseCase {

  Transfer find(Long id);

}
