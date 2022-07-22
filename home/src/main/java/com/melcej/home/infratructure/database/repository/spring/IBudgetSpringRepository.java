package com.melcej.home.infratructure.database.repository.spring;

import com.melcej.home.infratructure.database.entity.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBudgetSpringRepository extends JpaRepository<BudgetEntity, Long> {

}
