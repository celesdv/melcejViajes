package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Assistance;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListAssistanceUseCase {

  Page<Assistance> findAll(PageRequest pageRequest);

  List<Assistance> findAllByBudget(Long id);

}
