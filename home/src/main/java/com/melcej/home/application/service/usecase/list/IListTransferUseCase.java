package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Transfer;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListTransferUseCase {

  Page<Transfer> findAll(PageRequest pageRequest);

  List<Transfer> findAllByBudget(Long id);

}
