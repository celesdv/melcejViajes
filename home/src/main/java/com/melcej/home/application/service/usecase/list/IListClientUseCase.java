package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Client;
import java.util.List;

public interface IListClientUseCase {

  List<Client> findAll();

}
