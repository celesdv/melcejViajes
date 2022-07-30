package com.melcej.home.application.repository;

import com.melcej.home.domain.Pax;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IPaxRepository {

  Pax add(Pax pax);

  boolean existsById(Long id);

  boolean isDeleted(Long id);

  void delete(Long id);

  Page<Pax> findAll(PageRequest pageRequest);

  Pax findBy(Long id);

  Pax update(Pax pax);

}
