package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Charge;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListChargeUseCase {

  Page<Charge> findAll(PageRequest pageRequest);

}
