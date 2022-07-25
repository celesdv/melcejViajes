package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Canned;
import com.melcej.home.infratructure.database.entity.CannedEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CannedEntityMapper {

  @Autowired
  private BudgetEntityMapper budgetEntityMapper;

  @Autowired
  private SupplierEntityMapper supplierEntityMapper;

  public Canned toDomain(CannedEntity cannedEntity){
    if (cannedEntity == null){
      return null;
    }
    return Canned.builder()
        .id(cannedEntity.getId())
        .budget(budgetEntityMapper.toDomain(cannedEntity.getBudget()))
        .type(cannedEntity.getType())
        .supplier(supplierEntityMapper.toDomain(cannedEntity.getSupplier()))
        .value(cannedEntity.getValue())
        .tax(cannedEntity.getTax())
        .detail(cannedEntity.getDetail())
        .build();
  }

  public List<Canned> toDomain(List<CannedEntity> cannedEntities){
    if (cannedEntities == null || cannedEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Canned> canned = new ArrayList<>(cannedEntities.size());
    for (CannedEntity cannedEntity : cannedEntities){
      canned.add(toDomain(cannedEntity));
    }
    return canned;
  }

  public CannedEntity toEntity(Canned canned){
    if (canned == null){
      return null;
    }
    return CannedEntity.builder()
        .id(canned.getId())
        .budget(budgetEntityMapper.toEntity(canned.getBudget()))
        .type(canned.getType())
        .supplier(supplierEntityMapper.toEntity(canned.getSupplier()))
        .value(canned.getValue())
        .tax(canned.getTax())
        .detail(canned.getDetail())
        .build();
  }

}
