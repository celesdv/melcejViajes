package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Pax;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListPaxUseCase {

  Page<Pax> findAll(PageRequest pageRequest);

}
