package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Supplier;
import java.util.List;

public interface IListSupplierUseCase {

  List<Supplier> findAll();

}
