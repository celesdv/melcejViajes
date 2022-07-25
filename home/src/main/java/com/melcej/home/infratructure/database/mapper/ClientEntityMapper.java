package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Client;
import com.melcej.home.infratructure.database.entity.ClientEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ClientEntityMapper {

  public Client toDomain(ClientEntity clientEntity){
    if(clientEntity == null){
      return null;
    }
    return Client.builder()
        .id(clientEntity.getId())
        .firstName(clientEntity.getFirstName())
        .lastName(clientEntity.getLastName())
        .cuil(clientEntity.getCuil())
        .address(clientEntity.getAddress())
        .email(clientEntity.getEmail())
        .phone(clientEntity.getPhone())
        .build();
  }

  public List<Client> toDomain(List<ClientEntity> clientEntities){
    if (clientEntities == null || clientEntities.isEmpty()) {
      return Collections.emptyList();
    }
    List<Client> clients = new ArrayList<>(clientEntities.size());
    for (ClientEntity clientEntity : clientEntities) {
      clients.add(toDomain(clientEntity));
    }
    return clients;
  }

  public ClientEntity toEntity(Client client){
    if(client == null){
      return null;
    }
    return ClientEntity.builder()
        .id(client.getId())
        .firstName(client.getFirstName())
        .lastName(client.getLastName())
        .cuil(client.getCuil())
        .address(client.getAddress())
        .phone(client.getPhone())
        .build();
  }
}
