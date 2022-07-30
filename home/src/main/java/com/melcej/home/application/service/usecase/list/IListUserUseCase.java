package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListUserUseCase {

  Page<User> findAll(PageRequest pageRequest);

}
