package com.melcej.home.infratructure.database.repository;

import com.melcej.home.infratructure.database.repository.spring.IOrganizationSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrganizationRepository {

  private final IOrganizationSpringRepository organizationSpringRepository;

}
