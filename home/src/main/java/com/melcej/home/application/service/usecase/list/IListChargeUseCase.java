package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Charge;
import java.util.List;

public interface IListChargeUseCase {

  List<Charge> findAll();

}
