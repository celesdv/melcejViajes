package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Canned;

public interface IGetCannedUseCase {

  Canned find(Long id);

}
