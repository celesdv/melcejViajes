package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Client;
import com.melcej.home.infratructure.database.entity.BudgetEntity;
import com.melcej.home.infratructure.database.entity.ClientEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetEntityMapper {

  @Autowired
  private OrderEntityMapper orderEntityMapper;

  public Budget toDomain(BudgetEntity budgetEntity){
    if (budgetEntity == null){
      return null;
    }
    return Budget.builder()
        .id(budgetEntity.getId())
        .order(orderEntityMapper.toDomain(budgetEntity.getOrder()))
        .detail(budgetEntity.getDetail())
        .totalPrice(budgetEntity.getTotalPrice())
        .build();
  }

  public List<Budget> toDomain(List<BudgetEntity> budgetEntities){
    if (budgetEntities == null || budgetEntities.isEmpty()) {
      return Collections.emptyList();
    }
    List<Budget> budgets = new ArrayList<>(budgetEntities.size());
    for (BudgetEntity budgetEntity : budgetEntities) {
      budgets.add(toDomain(budgetEntity));
    }
    return budgets;
  }

  public BudgetEntity toEntity(Budget budget){
    if (budget == null){
      return null;
    }
    return BudgetEntity.builder()
        .id(budget.getId())
        .order(orderEntityMapper.toEntity(budget.getOrder()))
        .detail(budget.getDetail())
        .totalPrice(budget.getTotalPrice())
        .build();
  }

}
