package com.melcej.home.infratructure.database.repository.spring;

import com.melcej.home.infratructure.database.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferSpringRepository extends JpaRepository<TransferEntity, Long> {

}
