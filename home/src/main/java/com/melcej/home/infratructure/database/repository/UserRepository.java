package com.melcej.home.infratructure.database.repository;

import com.melcej.home.application.repository.IUserRepository;
import com.melcej.home.domain.User;
import com.melcej.home.infratructure.database.entity.RoleEntity;
import com.melcej.home.infratructure.database.entity.UserEntity;
import com.melcej.home.infratructure.database.mapper.UserEntityMapper;
import com.melcej.home.infratructure.database.repository.spring.IRoleSpringRepository;
import com.melcej.home.infratructure.database.repository.spring.IUserSpringRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class UserRepository implements IUserRepository {

  private final IUserSpringRepository userSpringRepository;
  private final IRoleSpringRepository roleSpringRepository;
  private final UserEntityMapper userEntityMapper;

  @Override
  public User findByEmail(String email) {
    return userEntityMapper.toDomain(userSpringRepository.findByEmail(email));
  }

  @Override
  @Transactional
  public User add(User newUser) {
    UserEntity userEntity = userEntityMapper.toEntity(newUser);
    userEntity.setSoftDelete(false);
    userEntity.setRole(getRoleEntity(newUser.getRole().getName()));
    return userEntityMapper.toDomain(userSpringRepository.save(userEntity));
  }

  @Override
  public boolean existsById(Long id) {
    return userSpringRepository.existsById(id);
  }

  @Override
  public boolean isDeleted(Long id) {
    return userSpringRepository.isDeleted(id).isPresent();
  }

  @Override
  @Transactional
  public void delete(Long id) {
    userSpringRepository.softDeleteById(id);
  }

  @Override
  public List<User> findAllActive() {
    return userEntityMapper.toDomain(userSpringRepository.findBySoftDeleteFalse());
  }

  @Override
  public User findBy(Long id) {
    return userEntityMapper.toDomain(userSpringRepository.findByIdAndSoftDeleteFalse(id));
  }

  @Override
  public User update(User user) {
    UserEntity updatedUser = userEntityMapper.toEntity(user);
    updatedUser.setSoftDelete(false);
    return userEntityMapper.toDomain(userSpringRepository.save(updatedUser));
  }

  private RoleEntity getRoleEntity(String role) {
    return roleSpringRepository.findByName(role);
  }
}
