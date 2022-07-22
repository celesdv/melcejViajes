package com.melcej.home.infratructure.database.repository.spring;

import com.melcej.home.infratructure.database.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierSpringRepository extends JpaRepository<SupplierEntity, Long> {

}
