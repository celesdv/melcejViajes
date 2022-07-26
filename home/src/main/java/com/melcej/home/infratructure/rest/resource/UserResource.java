package com.melcej.home.infratructure.rest.resource;

import com.melcej.home.application.service.usecase.add.ICreateUserUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteUserUseCase;
import com.melcej.home.application.service.usecase.get.IGetAuthDetailsUseCase;
import com.melcej.home.application.service.usecase.list.IListUserUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateUserUseCase;
import com.melcej.home.domain.User;
import com.melcej.home.infratructure.rest.mapper.UserMapper;
import com.melcej.home.infratructure.rest.mapper.UserRegisterMapper;
import com.melcej.home.infratructure.rest.request.UpdateUserRequest;
import com.melcej.home.infratructure.rest.request.UserRegisterRequest;
import com.melcej.home.infratructure.rest.response.ListUserResponse;
import com.melcej.home.infratructure.rest.response.UserRegisterResponse;
import com.melcej.home.infratructure.rest.response.UserResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

  @Autowired
  private ICreateUserUseCase createUserUseCase;

  @Autowired
  private IDeleteUserUseCase deleteUserUseCase;

  @Autowired
  private IListUserUseCase listUserUseCase;

  @Autowired
  private IGetAuthDetailsUseCase getAuthDetailsUseCase;

  @Autowired
  private IUpdateUserUseCase updateUserUseCase;

  @Autowired
  private UserRegisterMapper userRegisterMapper;

  @Autowired
  private UserMapper userMapper;

  @PostMapping(value = "/auth/register",
      produces = {"application/json"},
      consumes = {"application/json"})
  public ResponseEntity<UserRegisterResponse> create(@Valid @RequestBody
  UserRegisterRequest registerRequest) {
    User user = userRegisterMapper.toDomain(registerRequest);
    UserRegisterResponse response = userRegisterMapper.toResponse(createUserUseCase.add(user));
    return new ResponseEntity<UserRegisterResponse>(response, HttpStatus.CREATED);
  }

  @GetMapping(value = "/auth/me",
      produces = {"application/json"})
  public ResponseEntity<UserResponse> getAuthDetails(
      @RequestHeader("Authorization") String authorizationHeader) {
    User user = userMapper.toDomain(authorizationHeader);
    UserResponse response = userMapper.toResponse(getAuthDetailsUseCase.getAuthDetails(user));
    return ResponseEntity.ok(response);
  }

  @DeleteMapping(value = "/users/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    deleteUserUseCase.delete(id);
    return ResponseEntity.noContent().build();
  }
  @GetMapping(value = "/users", produces = {"application/json"})
  public ResponseEntity<ListUserResponse> list() {
    List<User> users = listUserUseCase.findAll();
    return ResponseEntity.ok().body(userMapper.toResponse(users));
  }

  @PutMapping(value = "/users/{id}",
      produces = {"application/json"},
      consumes = {"application/json"})
  public ResponseEntity<UserResponse> update(@PathVariable Long id,
      @Valid @RequestBody UpdateUserRequest updateUserRequest) {
    User user = updateUserUseCase.update(userMapper.toDomain(id, updateUserRequest));
    UserResponse response = userMapper.toResponse(user);
    return ResponseEntity.ok(response);
  }

}
