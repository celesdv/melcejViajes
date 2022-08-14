package com.melcej.home.infratructure.config.seeder;

import com.melcej.home.infratructure.config.spring.security.common.Role;
import com.melcej.home.infratructure.database.entity.RoleEntity;
import com.melcej.home.infratructure.database.entity.UserEntity;
import com.melcej.home.infratructure.database.repository.spring.IRoleSpringRepository;
import com.melcej.home.infratructure.database.repository.spring.IUserSpringRepository;
import java.util.List;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log
@Configuration
@Profile("default")
public class SeedUser {

  private static final String ADMIN_EMAIL_I = "melcejviajes@gmail.com";
  private static final String USER_EMAIL_I = "eduardo.melcej@gmail.com";
  private static final String ADMIN_EMAIL_II = "celesdv@gmail.com";
  private static final String USER_EMAIL_II = "luzdangelo@gmail.com";
  private static final String PASSWORD = "abcd1234";

  @Autowired
  protected PasswordEncoder passwordEncoder;

  @Autowired
  protected IUserSpringRepository userRepository;

  @Autowired
  protected IRoleSpringRepository roleRepository;

  @Bean
  CommandLineRunner initUsersData() {
    return args -> {
      log.info("Loading initial Roles in Database...");
      createRoles();
      log.info("Loading initial Users in Database...");
      createStandardAndAdminUsers();
    };
  }

  private void createRoles() {
    if (roleRepository.count() == 0) {
      roleRepository.saveAll(List.of(
          buildRole(Role.USER),
          buildRole(Role.ADMIN)));
      log.info("Initial Roles created");
    }
  }

  private void createStandardAndAdminUsers() {
    if (userRepository.count() == 0) {
      userRepository.saveAll(List.of(
          buildUser("Eduardo", "Dangelo", ADMIN_EMAIL_I, Role.ADMIN),
          buildUser("Celeste", "Dangelo", ADMIN_EMAIL_II, Role.ADMIN),
          buildUser("Eduardo", "Dangelo", USER_EMAIL_I, Role.USER),
          buildUser("Luz", "Dangelo", USER_EMAIL_II, Role.USER)));
      log.info("Initial Users created");
    }
  }

  private RoleEntity buildRole(Role role) {
    return RoleEntity.builder()
        .description(role.name())
        .name(role.getFullRoleName())
        .build();
  }

  private UserEntity buildUser(String firstName, String lastName, String email, Role role) {
    return UserEntity.builder()
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .password(passwordEncoder.encode(PASSWORD))
        .role(roleRepository.findByName(role.getFullRoleName()))
        .softDelete(false)
        .build();
  }
}
