package com.melcej.home.infratructure.config.spring;

import com.melcej.home.application.repository.IOrganizationRepository;
import com.melcej.home.application.service.AuthenticationService;
import com.melcej.home.application.service.UserService;
import com.melcej.home.application.service.usecase.ILoginUseCase;
import com.melcej.home.application.service.usecase.add.ICreateUserUseCase;
import com.melcej.home.infratructure.database.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class ServiceBeanConfig {

  @Bean
  public ILoginUseCase loginUseCase(AuthenticationManager authenticationManager,
      UserRepository userRepository) {
    return new AuthenticationService(authenticationManager, userRepository);
  }

  @Bean
  public ICreateUserUseCase createUserUseCase(UserRepository userRepository) {
    return new UserService(userRepository);
  }

}
