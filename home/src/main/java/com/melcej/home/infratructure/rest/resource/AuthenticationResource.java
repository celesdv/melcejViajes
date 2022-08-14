package com.melcej.home.infratructure.rest.resource;

import com.melcej.home.application.service.usecase.ILoginUseCase;
import com.melcej.home.domain.User;
import com.melcej.home.infratructure.rest.mapper.AuthenticationMapper;
import com.melcej.home.infratructure.rest.request.AuthenticationRequest;
import com.melcej.home.infratructure.rest.response.AuthenticationResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationResource {

  @Autowired
  private ILoginUseCase loginUseCase;

  @Autowired
  private AuthenticationMapper authenticationMapper;

  @PostMapping(value = "/auth/login",
      produces = {"application/json"},
      consumes = {"application/json"})
  public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid
  AuthenticationRequest authenticationRequest) {
    User user = loginUseCase.login(authenticationMapper.toDomain(authenticationRequest));
    return ResponseEntity.ok().body(authenticationMapper.toResponse(user));
  }

}
