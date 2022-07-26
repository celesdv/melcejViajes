package com.melcej.home.application.repository;

import com.melcej.home.domain.Transfer;
import java.util.List;

public interface ITransferRepository {

  Transfer add(Transfer transfer);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  List<Transfer> findAllActive();

  Transfer findBy(Long id);

  Transfer update(Transfer transfer);

}
