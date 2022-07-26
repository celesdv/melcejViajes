package com.melcej.home.infratructure.rest.mapper;

import com.melcej.home.domain.Role;
import com.melcej.home.domain.User;
import com.melcej.home.infratructure.config.spring.security.common.JwtUtils;
import com.melcej.home.infratructure.rest.request.UpdateUserRequest;
import com.melcej.home.infratructure.rest.response.ListUserResponse;
import com.melcej.home.infratructure.rest.response.UserResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public ListUserResponse toResponse(List<User> users) {
    if (users == null || users.isEmpty()) {
      return new ListUserResponse(Collections.emptyList());
    }

    List<UserResponse> userResponses = new ArrayList<>(users.size());
    for (User user : users) {
      userResponses.add(toResponse(user));
    }
    return new ListUserResponse(userResponses);
  }

  public UserResponse toResponse(User user) {
    return UserResponse.builder()
        .email(user.getEmail())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .phone(user.getPhone())
        .build();
  }

  public User toDomain(String authorizationHeader) {
    return User.builder()
        .email(extractEmail(authorizationHeader))
        .role(Role.builder()
            .name(extractAuthorities(authorizationHeader))
            .build())
        .build();
  }

  public User toDomain(Long id, UpdateUserRequest updateUserRequest) {
    return User.builder()
        .id(id)
        .firstName(updateUserRequest.getFirstName())
        .lastName(updateUserRequest.getLastName())
        .email(updateUserRequest.getEmail())
        .password(passwordEncoder.encode(updateUserRequest.getPassword()))
        .phone(updateUserRequest.getPhone())
        .build();
  }

  private String extractEmail(String token) {
    return jwtUtils.extractUsername(token);
  }

  private String extractAuthorities(String token) {
    Optional<GrantedAuthority> authority = jwtUtils.getAuthorities(token).stream().findFirst();
    if (authority.isEmpty()) {
      throw new IllegalArgumentException("Authority is empty.");
    }
    return authority.get().toString();
  }

}
