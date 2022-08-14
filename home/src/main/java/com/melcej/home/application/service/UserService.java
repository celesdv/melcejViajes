package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IUserRepository;
import com.melcej.home.application.service.usecase.add.ICreateUserUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteUserUseCase;
import com.melcej.home.application.service.usecase.get.IGetAuthDetailsUseCase;
import com.melcej.home.application.service.usecase.list.IListUserUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateUserUseCase;
import com.melcej.home.domain.User;
import com.melcej.home.infratructure.config.spring.security.common.Role;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Slf4j
@AllArgsConstructor
public class UserService implements ICreateUserUseCase, IDeleteUserUseCase, IListUserUseCase,
    IGetAuthDetailsUseCase, IUpdateUserUseCase {

  private final IUserRepository userRepository;

  @Override
  public User add(User user) {
    user.setRole(com.melcej.home.domain.Role.builder()
        .name(Role.USER.getFullRoleName())
        .build());
    User newUser = userRepository.add(user);
    return newUser;
  }

  @Override
  public void delete(Long id) {
    if (!userRepository.existsById(id) || userRepository.isDeleted(id)) {
      throw new RecordNotFoundException("User not found.");
    }
    userRepository.delete(id);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAllActive();
  }

  @Override
  public User getAuthDetails(User user) {
    return getUserBy(user.getEmail());
  }

  @Override
  public User update(User updatedUser) {
    User savedUser = userRepository.findBy(updatedUser.getId());
    if (savedUser == null) {
      throw new RecordNotFoundException("User not found.");
    }
    updateUserValues(updatedUser, savedUser);
    return userRepository.update(savedUser);
  }

  private User getUserBy(String email) {
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new RecordNotFoundException("User not found.");
    }
    return user;
  }

  private void updateUserValues(User updatedUser, User savedUser) {
    updateCredentials(savedUser, updatedUser);
    updateOptionalInfo(savedUser, updatedUser);
  }

  private void updateCredentials(User savedUser, User updatedUser) {
    savedUser.setEmail(updatedUser.getEmail());
    savedUser.setPassword(updatedUser.getPassword());
  }

  private void updateOptionalInfo(User savedUser, User updatedUser) {
    savedUser.setFirstName(updatedUser.getFirstName());
    savedUser.setLastName(updatedUser.getLastName());
    savedUser.setPhone(updatedUser.getPhone());
  }

}
