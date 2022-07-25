package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.User;
import com.melcej.home.infratructure.config.spring.config.common.JwtUtils;
import com.melcej.home.infratructure.database.entity.UserEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private RoleEntityMapper roleEntityMapper;

  public List<User> toDomain(List<UserEntity> userEntities) {
    if (userEntities == null || userEntities.isEmpty()) {
      return Collections.emptyList();
    }
    List<User> users = new ArrayList<>(userEntities.size());
    for (UserEntity userEntity : userEntities) {
      users.add(toDomain(userEntity));
    }
    return users;
  }

  public User toDomain(UserEntity userEntity) {
    if (userEntity == null) {
      return null;
    }
    return User.builder()
        .id(userEntity.getId())
        .email(userEntity.getEmail())
        .firstName(userEntity.getFirstName())
        .lastName(userEntity.getLastName())
        .password(userEntity.getPassword())
        .token(getToken(userEntity))
        .role(roleEntityMapper.toDomain(userEntity.getRole()))
        .build();
  }

  public UserEntity toEntity(User user) {
    if (user == null) {
      return null;
    }
    return UserEntity.builder()
        .id(user.getId())
        .email(user.getEmail())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .password(user.getPassword())
        .role(roleEntityMapper.toEntity(user.getRole()))
        .build();
  }

  private String getToken(UserEntity userEntity) {
    return userEntity.getRole() == null ? "NOT_TOKEN" : jwtUtils.generateToken(userEntity);
  }

}
