package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Excursion;
import com.melcej.home.infratructure.database.entity.ExcursionEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExcursionEntityMapper {

  @Autowired
  private BudgetEntityMapper budgetEntityMapper;

  @Autowired
  private SupplierEntityMapper supplierEntityMapper;

  public Excursion toDomain(ExcursionEntity excursionEntity){
    if (excursionEntity == null){
      return null;
    }
    return Excursion.builder()
        .id(excursionEntity.getId())
        .budget(budgetEntityMapper.toDomain(excursionEntity.getBudget()))
        .name(excursionEntity.getName())
        .date(excursionEntity.getDate())
        .supplier(supplierEntityMapper.toDomain(excursionEntity.getSupplier()))
        .value(excursionEntity.getValue())
        .tax(excursionEntity.getTax())
        .detail(excursionEntity.getDetail())
        .build();
  }

  public List<Excursion> toDomain(List<ExcursionEntity> excursionEntities){
    if (excursionEntities == null || excursionEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Excursion> excursions = new ArrayList<>(excursionEntities.size());
    for (ExcursionEntity excursionEntity : excursionEntities){
      excursions.add(toDomain(excursionEntity));
    }
    return excursions;
  }

  public ExcursionEntity toEntity(Excursion excursion){
    if (excursion == null){
      return null;
    }
    return ExcursionEntity.builder()
        .id(excursion.getId())
        .budget(budgetEntityMapper.toEntity(excursion.getBudget()))
        .name(excursion.getName())
        .date(excursion.getDate())
        .supplier(supplierEntityMapper.toEntity(excursion.getSupplier()))
        .value(excursion.getValue())
        .tax(excursion.getTax())
        .detail(excursion.getDetail())
        .build();
  }

}
