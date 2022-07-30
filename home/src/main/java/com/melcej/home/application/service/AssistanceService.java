package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IAssistanceRepository;
import com.melcej.home.application.service.usecase.add.ICreateAssistanceUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteAssistanceUseCase;
import com.melcej.home.application.service.usecase.get.IGetAssistanceUseCase;
import com.melcej.home.application.service.usecase.list.IListAssistanceUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateAssistanceUseCase;
import com.melcej.home.domain.Assistance;
import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Supplier;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class AssistanceService implements ICreateAssistanceUseCase, IDeleteAssistanceUseCase,
    IGetAssistanceUseCase, IListAssistanceUseCase, IUpdateAssistanceUseCase {

  private final IAssistanceRepository assistanceRepository;

  @Override
  public Assistance add(Assistance assistance) {
    assistance.setSoftDelete(false);
    return assistanceRepository.add(assistance);
  }

  @Override
  public void delete(Long id) {
    if (!assistanceRepository.existsById(id) || assistanceRepository.isDeleted(id)) {
      throw new RecordNotFoundException("Assistance not found.");
    }
    assistanceRepository.delete(id);
  }

  @Override
  public Assistance find(@PathVariable Long id) {
    Assistance assistance = assistanceRepository.findBy(id);
    if (assistance == null || Boolean.TRUE.equals(assistance.getSoftDelete())){
      throw new RecordNotFoundException("Assistance not found.");
    }
    return assistance;
  }

  @Override
  public Page<Assistance> findAll(PageRequest pageRequest) {
    return assistanceRepository.findAll(pageRequest);
  }

  @Override
  public List<Assistance> findAllByBudget(Long id) {
    return assistanceRepository.findAllByBudget(id);
  }

  @Override
  public Assistance update(Assistance assistanceUpdate) {
    Assistance assistanceSaved = find(assistanceUpdate.getId());
    assistanceSaved.setSoftDelete(false);
    updateValues(assistanceUpdate, assistanceSaved);
    return assistanceRepository.update(assistanceSaved);
  }

  private void updateValues(Assistance assistanceUpdate, Assistance assistanceSaved){
    Budget budget = assistanceUpdate.getBudget();
    if (budget != null){
      assistanceSaved.setBudget(budget);
    }

    String type = assistanceUpdate.getType();
    if (type != null){
      assistanceSaved.setType(type);
    }

    Supplier supplier = assistanceUpdate.getSupplier();
    if (supplier != null){
      assistanceSaved.setSupplier(supplier);
    }

    Double value = assistanceUpdate.getValue();
    if (value != null){
      assistanceSaved.setValue(value);
    }

    Double tax = assistanceUpdate.getTax();
    if (tax != null){
      assistanceSaved.setTax(tax);
    }

    String detail = assistanceUpdate.getDetail();
    if (detail != null){
      assistanceSaved.setDetail(detail);
    }
  }

}
