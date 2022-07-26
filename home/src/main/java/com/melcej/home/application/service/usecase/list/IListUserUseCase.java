package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.User;
import java.util.List;

public interface IListUserUseCase {

  List<User> findAll();

}
