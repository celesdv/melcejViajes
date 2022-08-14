package com.melcej.home.infratructure.rest.mapper;

import com.melcej.home.domain.User;
import com.melcej.home.infratructure.rest.request.AuthenticationRequest;
import com.melcej.home.infratructure.rest.response.AuthenticationResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMapper {

  public User toDomain(AuthenticationRequest authenticationRequest) {
    if (authenticationRequest == null) {
      return null;
    }
    return User.builder()
        .email(authenticationRequest.getEmail())
        .password(authenticationRequest.getPassword())
        .build();
  }

  public AuthenticationResponse toResponse(User user) {
    if (user == null) {
      return null;
    }
    return AuthenticationResponse.builder()
        .email(user.getEmail())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .phone(user.getPhone())
        .token(user.getToken())
        .build();
  }

}
