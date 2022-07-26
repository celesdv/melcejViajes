package com.melcej.home.application.service.usecase.get;

import com.melcej.home.domain.Budget;

public interface IGetBudgetUseCase {

  Budget find(Long id);

}
