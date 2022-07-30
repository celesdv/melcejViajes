package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Supplier;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListSupplierUseCase {

  Page<Supplier> findAll(PageRequest pageRequest);

}
