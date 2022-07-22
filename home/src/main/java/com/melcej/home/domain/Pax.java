package com.melcej.home.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Pax {

  private Long id;
  private Booking booking;
  private String firstName;
  private String lastName;
  private String dni;
  private String passport;
  private LocalDate passportExpiration;
  private LocalDate birthDate;
  private Boolean softDelete;

}
