package com.melcej.home.application.repository;

import com.melcej.home.domain.Transfer;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ITransferRepository {

  Transfer add(Transfer transfer);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Transfer> findAll(PageRequest pageRequest);

  Transfer findBy(Long id);

  Transfer update(Transfer transfer);

}
