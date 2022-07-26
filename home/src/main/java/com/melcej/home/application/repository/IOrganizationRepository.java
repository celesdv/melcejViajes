package com.melcej.home.application.repository;

import com.melcej.home.domain.Organization;

public interface IOrganizationRepository {

  Organization find();

  Organization update(Organization organization);

}
