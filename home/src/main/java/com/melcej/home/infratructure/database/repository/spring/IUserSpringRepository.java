package com.melcej.home.infratructure.database.repository.spring;

import com.melcej.home.infratructure.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserSpringRepository extends JpaRepository<UserEntity, Long> {

}
