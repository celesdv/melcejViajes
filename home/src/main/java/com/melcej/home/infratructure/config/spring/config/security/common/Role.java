package com.melcej.home.infratructure.config.spring.config.security.common;

public enum Role {

  ADMIN, MANAGER, USER;

  private static final String ROLE_PREFIX = "ROLE_";

  public String getFullRoleName() {
    return ROLE_PREFIX + this.name();
  }

}
