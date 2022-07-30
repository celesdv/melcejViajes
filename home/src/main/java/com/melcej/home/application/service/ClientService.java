package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IClientRepository;
import com.melcej.home.application.service.usecase.add.ICreateClientUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteClientUseCase;
import com.melcej.home.application.service.usecase.get.IGetClientUseCase;
import com.melcej.home.application.service.usecase.list.IListClientUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateClientUseCase;
import com.melcej.home.domain.Client;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class ClientService implements ICreateClientUseCase, IDeleteClientUseCase,
    IGetClientUseCase, IListClientUseCase, IUpdateClientUseCase {

  private final IClientRepository clientRepository;

  @Override
  public Client add(Client client) {
    client.setSoftDelete(false);
    return clientRepository.add(client);
  }

  @Override
  public void delete(Long id) {
    if (!clientRepository.existsById(id) || clientRepository.isDeleted(id)) {
      throw new RecordNotFoundException("Client not found.");
    }
    clientRepository.delete(id);
  }

  @Override
  public Client find(@PathVariable Long id) {
    Client client = clientRepository.findBy(id);
    if (client == null || Boolean.TRUE.equals(client.getSoftDelete())) {
      throw new RecordNotFoundException("Client not found.");
    }
    return client;
  }

  @Override
  public Page<Client> findAll(PageRequest pageRequest) {
    return clientRepository.findAll(pageRequest);
  }

  @Override
  public Client update(Client clientUpdate) {
    Client clientSaved = find(clientUpdate.getId());
    clientSaved.setSoftDelete(false);
    updateValues(clientUpdate, clientSaved);
    return clientRepository.update(clientSaved);
  }

  private void updateValues(Client clientUpdate, Client clientSaved){
    String firstName = clientUpdate.getFirstName();
    if (firstName != null) {
      clientSaved.setFirstName(firstName);
    }

    String lastName = clientUpdate.getLastName();
    if (lastName != null) {
      clientSaved.setLastName(lastName);
    }

    String cuil = clientUpdate.getCuil();
    if (cuil != null) {
      clientSaved.setCuil(cuil);
    }

    String address = clientUpdate.getAddress();
    if (address != null) {
      clientSaved.setAddress(address);
    }

    String email = clientUpdate.getEmail();
    if (email != null) {
      clientSaved.setEmail(email);
    }

    String phone = clientUpdate.getPhone();
    if (phone != null) {
      clientSaved.setPhone(phone);
    }
  }
}
