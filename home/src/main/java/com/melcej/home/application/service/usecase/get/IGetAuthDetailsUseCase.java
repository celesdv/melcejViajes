package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.User;

public interface IGetAuthDetailsUseCase {

  User getAuthDetails(User user);

}
