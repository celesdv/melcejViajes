package com.melcej.home.infratructure.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserResponse {

  private String email;

  private String firstName;

  private String lastName;

  private String phone;
}
