package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.ICannedRepository;
import com.melcej.home.application.service.usecase.add.ICreateCannedUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteCannedUseCase;
import com.melcej.home.application.service.usecase.get.IGetCannedUseCase;
import com.melcej.home.application.service.usecase.list.IListCannedUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateCannedUseCase;
import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Canned;
import com.melcej.home.domain.Supplier;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class CannedService implements ICreateCannedUseCase, IDeleteCannedUseCase,
    IGetCannedUseCase, IListCannedUseCase, IUpdateCannedUseCase {

  private final ICannedRepository cannedRepository;

  @Override
  public Canned add(Canned canned) {
    canned.setSoftDelete(false);
    return cannedRepository.add(canned);
  }

  @Override
  public void delete(Long id) {
    if (!cannedRepository.existsById(id) || cannedRepository.isDeleted(id)){
      throw new RecordNotFoundException("Canned not found.");
    }
    cannedRepository.delete(id);
  }

  @Override
  public Canned find(@PathVariable Long id) {
    Canned canned = cannedRepository.findBy(id);
    if (canned == null || Boolean.TRUE.equals(canned.getSoftDelete())){
      throw new RecordNotFoundException("Canned not found.");
    }
    return canned;
  }

  @Override
  public Page<Canned> findAll(PageRequest pageRequest) {
    return cannedRepository.findAll(pageRequest);
  }

  @Override
  public Canned update(Canned cannedUpdate) {
    Canned cannedSaved = find(cannedUpdate.getId());
    cannedSaved.setSoftDelete(false);
    updateValues(cannedSaved, cannedUpdate);
    return cannedRepository.update(cannedSaved);
  }

  private void updateValues(Canned cannedSaved, Canned cannedUpdate) {
    Budget budget = cannedUpdate.getBudget();
    if (budget != null){
      cannedSaved.setBudget(budget);
    }

    String type = cannedUpdate.getType();
    if (type != null){
      cannedSaved.setType(type);
    }

    Supplier supplier = cannedUpdate.getSupplier();
    if (supplier != null){
      cannedSaved.setSupplier(supplier);
    }

    Double value = cannedUpdate.getValue();
    if (value != null){
      cannedSaved.setValue(value);
    }

    Double tax = cannedUpdate.getTax();
    if (tax != null){
      cannedSaved.setTax(tax);
    }

    String detail = cannedUpdate.getDetail();
    if (detail != null){
      cannedSaved.setDetail(detail);
    }
  }
}
