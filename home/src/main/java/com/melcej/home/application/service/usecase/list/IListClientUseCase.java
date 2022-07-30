package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Client;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListClientUseCase {

  Page<Client> findAll(PageRequest pageRequest);

}
