package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Excursion;
import java.util.List;

public interface IListExcursionUseCase {

  List<Excursion> findAll();

}
