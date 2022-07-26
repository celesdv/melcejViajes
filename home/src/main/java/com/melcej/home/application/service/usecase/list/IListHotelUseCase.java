package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Hotel;
import java.util.List;

public interface IListHotelUseCase {

  List<Hotel> findAll();

}
