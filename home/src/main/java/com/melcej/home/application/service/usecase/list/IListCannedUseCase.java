package com.melcej.home.application.service.usecase.list;

import com.melcej.home.domain.Canned;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IListCannedUseCase {

  Page<Canned> findAll(PageRequest pageRequest);

}
