package com.melcej.home.application.repository;

import com.melcej.home.domain.Client;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IClientRepository {

  Client add(Client client);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Client> findAll(PageRequest pageRequest);

  Client findBy(Long id);

  Client update(Client client);

}
