package com.melcej.home.infratructure.rest.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserRegisterRequest {

  @Pattern(regexp = "^\\p{L}+[\\p{L}\\s]*$",
      message = "Name can only contain letters and whitespaces")
  private String firstName;

  @Pattern(regexp = "^\\p{L}+[\\p{L}\\s]*$",
      message = "Lastname can only contain letters and whitespaces")
  private String lastName;

  @Email(message = "Email should be valid")
  private String email;

  @Size(min = 6, max = 8, message = "Password must be between 6 and 8 characters")
  private String password;

}
