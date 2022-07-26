package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IExcursionRepository;
import com.melcej.home.application.service.usecase.add.ICreateExcursionUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteExcursionUseCase;
import com.melcej.home.application.service.usecase.get.IGetExcursionUseCase;
import com.melcej.home.application.service.usecase.list.IListExcursionUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateExcursionUseCase;
import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Excursion;
import com.melcej.home.domain.Supplier;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class ExcursionService implements ICreateExcursionUseCase, IDeleteExcursionUseCase,
    IGetExcursionUseCase, IListExcursionUseCase, IUpdateExcursionUseCase {

  private final IExcursionRepository excursionRepository;

  @Override
  public Excursion add(Excursion excursion) {
    excursion.setSoftDelete(false);
    return excursionRepository.add(excursion);
  }

  @Override
  public void delete(Long id) {
    if (!excursionRepository.existsById(id) || excursionRepository.isDeleted(id)){
      throw new RecordNotFoundException("Excursion not found.");
    }
    excursionRepository.delete(id);
  }

  @Override
  public Excursion find(@PathVariable Long id) {
    Excursion excursion = excursionRepository.findBy(id);
    if (excursion == null || Boolean.TRUE.equals(excursion.getSoftDelete())){
      throw new RecordNotFoundException("Excursion not found.");
    }
    return excursion;
  }

  @Override
  public List<Excursion> findAll() {
    // TODO: 26/7/2022
    return null;
  }

  @Override
  public Excursion update(Excursion excursionUpdate) {
    Excursion excursionSaved = find(excursionUpdate.getId());
    excursionSaved.setSoftDelete(false);
    updateValues(excursionSaved, excursionUpdate);
    return excursionRepository.update(excursionSaved);
  }

  private void updateValues(Excursion excursionSaved, Excursion excursionUpdate) {
    Budget budget = excursionUpdate.getBudget();
    if (budget != null){
      excursionSaved.setBudget(budget);
    }

    String name = excursionUpdate.getName();
    if (name != null){
      excursionSaved.setName(name);
    }

    String date = excursionUpdate.getDate();
    if (date != null){
      excursionSaved.setDate(date);
    }

    Supplier supplier = excursionUpdate.getSupplier();
    if (supplier != null){
      excursionSaved.setSupplier(supplier);
    }

    Double value = excursionUpdate.getValue();
    if (value != null){
      excursionSaved.setValue(value);
    }

    Double tax = excursionUpdate.getTax();
    if (tax != null){
      excursionSaved.setTax(tax);
    }

    String detail = excursionUpdate.getDetail();
    if (detail != null){
      excursionSaved.setDetail(detail);
    }
  }
}
