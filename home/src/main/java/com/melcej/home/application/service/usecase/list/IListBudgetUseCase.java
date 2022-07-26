package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Budget;
import java.util.List;

public interface IListBudgetUseCase {

  List<Budget> findAll();

}
