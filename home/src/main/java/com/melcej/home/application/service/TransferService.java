package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.ITransferRepository;
import com.melcej.home.application.service.usecase.add.ICreateTransferUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteTransferUseCase;
import com.melcej.home.application.service.usecase.get.IGetTransferUseCase;
import com.melcej.home.application.service.usecase.list.IListTransferUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateTransferUseCase;
import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Supplier;
import com.melcej.home.domain.Transfer;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class TransferService implements ICreateTransferUseCase, IDeleteTransferUseCase,
    IGetTransferUseCase, IListTransferUseCase, IUpdateTransferUseCase {

  private final ITransferRepository transferRepository;

  @Override
  public Transfer add(Transfer transfer) {
    transfer.setSoftDelete(false);
    return transferRepository.add(transfer);
  }

  @Override
  public void delete(Long id) {
    if (!transferRepository.existsById(id) || transferRepository.isDeleted(id)){
      throw new RecordNotFoundException("Transfer not found");
    }
    transferRepository.delete(id);
  }

  @Override
  public Transfer find(@PathVariable Long id) {
    Transfer transfer = transferRepository.findBy(id);
    if (transfer == null || Boolean.TRUE.equals(transfer.getSoftDelete())){
      throw new RecordNotFoundException("Transfer not found");
    }
    return transfer;
  }

  @Override
  public List<Transfer> findAll() {
    // TODO: 27/7/2022
    return null;
  }

  @Override
  public Transfer update(Transfer transferUpdate) {
    Transfer transferSaved = find(transferUpdate.getId());
    transferSaved.setSoftDelete(false);
    updateValues(transferSaved, transferUpdate);
    return transferRepository.update(transferSaved);
  }

  private void updateValues(Transfer transferSaved, Transfer transferUpdate) {
    Budget budget = transferUpdate.getBudget();
    if (budget != null){
      transferSaved.setBudget(budget);
    }

    String type = transferUpdate.getType();
    if (type != null){
      transferSaved.setType(type);
    }

    String conveyance = transferUpdate.getConveyance();
    if (conveyance != null){
      transferSaved.setConveyance(conveyance);
    }

    String origin = transferUpdate.getOrigin();
    if (origin != null){
      transferSaved.setOrigin(origin);
    }

    String destination = transferUpdate.getDestination();
    if (destination != null){
      transferSaved.setDestination(destination);
    }

    Supplier supplier = transferUpdate.getSupplier();
    if (supplier != null){
      transferSaved.setSupplier(supplier);
    }

    Double value = transferUpdate.getValue();
    if (value != null){
      transferSaved.setValue(value);
    }

    Double tax = transferUpdate.getTax();
    if (tax != null){
      transferSaved.setTax(tax);
    }

    String detail = transferUpdate.getDetail();
    if (detail != null){
      transferSaved.setDetail(detail);
    }
  }
}
