package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Transfer;
import com.melcej.home.infratructure.database.entity.TransferEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferEntityMapper {

  @Autowired
  private BudgetEntityMapper budgetEntityMapper;

  @Autowired
  private SupplierEntityMapper supplierEntityMapper;

  public Transfer toDomain(TransferEntity transferEntity){
    if (transferEntity == null){
      return null;
    }
    return Transfer.builder()
        .id(transferEntity.getId())
        .budget(budgetEntityMapper.toDomain(transferEntity.getBudget()))
        .type(transferEntity.getType())
        .conveyance(transferEntity.getConveyance())
        .origin(transferEntity.getOrigin())
        .destination(transferEntity.getDestination())
        .supplier(supplierEntityMapper.toDomain(transferEntity.getSupplier()))
        .value(transferEntity.getValue())
        .tax(transferEntity.getTax())
        .detail(transferEntity.getDetail())
        .build();
  }

  public List<Transfer> toDomain(List<TransferEntity> transferEntities){
    if (transferEntities == null || transferEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Transfer> transfers = new ArrayList<>(transferEntities.size());
    for (TransferEntity transferEntity: transferEntities) {
      transfers.add(toDomain(transferEntity));
    }
    return transfers;
  }

  public TransferEntity toEntity(Transfer transfer){
    if (transfer == null){
      return null;
    }
    return TransferEntity.builder()
        .id(transfer.getId())
        .budget(budgetEntityMapper.toEntity(transfer.getBudget()))
        .type(transfer.getType())
        .conveyance(transfer.getConveyance())
        .origin(transfer.getOrigin())
        .destination(transfer.getDestination())
        .supplier(supplierEntityMapper.toEntity(transfer.getSupplier()))
        .value(transfer.getValue())
        .tax(transfer.getTax())
        .detail(transfer.getDetail())
        .build();
  }

}
