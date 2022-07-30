package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Hotel;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListHotelUseCase {

  Page<Hotel> findAll(PageRequest pageRequest);

  List<Hotel> findAllByBudget(Long id);

}
