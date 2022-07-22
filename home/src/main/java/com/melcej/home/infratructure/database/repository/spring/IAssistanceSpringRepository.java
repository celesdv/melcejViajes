package com.melcej.home.infratructure.database.repository.spring;

import com.melcej.home.infratructure.database.entity.AssistanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssistanceSpringRepository extends JpaRepository<AssistanceEntity, Long> {

}
