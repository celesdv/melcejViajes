package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Role;
import com.melcej.home.infratructure.database.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleEntityMapper {

  public Role toDomain(RoleEntity roleEntity) {
    if (roleEntity == null) {
      return null;
    }
    return Role.builder()
        .id(roleEntity.getId())
        .name(roleEntity.getName())
        .description(roleEntity.getDescription())
        .build();
  }

  public RoleEntity toEntity(Role role) {
    if (role == null) {
      return null;
    }
    return RoleEntity.builder()
        .id(role.getId())
        .name(role.getName())
        .description(role.getDescription())
        .build();
  }

}
