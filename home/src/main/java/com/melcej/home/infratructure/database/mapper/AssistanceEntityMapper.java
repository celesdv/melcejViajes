package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Assistance;
import com.melcej.home.infratructure.database.entity.AssistanceEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssistanceEntityMapper {

  @Autowired
  private BudgetEntityMapper budgetEntityMapper;

  @Autowired
  private SupplierEntityMapper supplierEntityMapper;

  public Assistance toDomain(AssistanceEntity assistanceEntity){
    if (assistanceEntity == null){
      return null;
    }
    return Assistance.builder()
        .id(assistanceEntity.getId())
        .budget(budgetEntityMapper.toDomain(assistanceEntity.getBudget()))
        .type(assistanceEntity.getType())
        .supplier(supplierEntityMapper.toDomain(assistanceEntity.getSupplier()))
        .value(assistanceEntity.getValue())
        .tax(assistanceEntity.getTax())
        .detail(assistanceEntity.getDetail())
        .build();
  }

  public List<Assistance> toDomain(List<AssistanceEntity> assistanceEntities){
    if (assistanceEntities == null || assistanceEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Assistance> assistance = new ArrayList<>(assistanceEntities.size());
    for (AssistanceEntity assistanceEntity : assistanceEntities){
      assistance.add(toDomain(assistanceEntity));
    }
    return assistance;
  }

  public AssistanceEntity toEntity(Assistance assistance){
    if (assistance == null){
      return null;
    }
    return AssistanceEntity.builder()
        .id(assistance.getId())
        .budget(budgetEntityMapper.toEntity(assistance.getBudget()))
        .type(assistance.getType())
        .supplier(supplierEntityMapper.toEntity(assistance.getSupplier()))
        .value(assistance.getValue())
        .tax(assistance.getTax())
        .detail(assistance.getDetail())
        .build();
  }

}
