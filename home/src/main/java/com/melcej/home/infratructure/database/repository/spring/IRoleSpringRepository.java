package com.melcej.home.infratructure.database.repository.spring;

import com.melcej.home.infratructure.database.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleSpringRepository extends JpaRepository<RoleEntity, Long> {

  RoleEntity findByName(String fullRoleName);

}
