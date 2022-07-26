package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Pax;
import java.util.List;

public interface IListPaxUseCase {

  List<Pax> findAll();

}
