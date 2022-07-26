package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Assistance;
import java.util.List;

public interface IListAssistanceUseCase {

  List<Assistance> findAll();

}
