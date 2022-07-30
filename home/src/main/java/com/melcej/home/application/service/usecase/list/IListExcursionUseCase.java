package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Excursion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListExcursionUseCase {

  Page<Excursion> findAll(PageRequest pageRequest);

}
