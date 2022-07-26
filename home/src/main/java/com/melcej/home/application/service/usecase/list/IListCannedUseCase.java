package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Canned;
import java.util.List;

public interface IListCannedUseCase {

  List<Canned> findAll();

}
