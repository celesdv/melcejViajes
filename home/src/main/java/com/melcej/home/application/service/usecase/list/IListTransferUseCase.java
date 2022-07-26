package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Transfer;
import java.util.List;

public interface IListTransferUseCase {

  List<Transfer> findAll();

}
