package com.melcej.home.application.repository;

import com.melcej.home.domain.Client;
import java.util.List;

public interface IClientRepository {

  Client add(Client client);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Client> findAllActive();

  Client findBy(Long id);

  Client update(Client client);

}
