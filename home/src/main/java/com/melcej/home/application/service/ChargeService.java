package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IChargeRepository;
import com.melcej.home.application.service.usecase.add.ICreateChargeUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteChargeUseCase;
import com.melcej.home.application.service.usecase.get.IGetChargeUseCase;
import com.melcej.home.application.service.usecase.list.IListChargeUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateChargeUseCase;
import com.melcej.home.domain.Charge;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class ChargeService implements ICreateChargeUseCase, IDeleteChargeUseCase,
    IGetChargeUseCase, IListChargeUseCase, IUpdateChargeUseCase {

  private final IChargeRepository chargeRepository;
  
  @Override
  public Charge add(Charge charge) {
    charge.setSoftDelete(false);
    return chargeRepository.add(charge);
  }

  @Override
  public void delete(Long id) {
    if (!chargeRepository.existsById(id) || chargeRepository.isDeleted(id)){
      throw new RecordNotFoundException("Charge not found.");
    }
    chargeRepository.delete(id);
  }

  @Override
  public Charge find(@PathVariable Long id) {
    Charge charge = chargeRepository.findBy(id);
    if (charge == null || Boolean.TRUE.equals(charge.getSoftDelete())){
      throw new RecordNotFoundException("Charge not found.");
    }
    return charge;
  }

  @Override
  public List<Charge> findAll() {
    // TODO: 26/7/2022  
    return null;
  }

  @Override
  public Charge update(Charge charge) {
    return null;
  }
}
