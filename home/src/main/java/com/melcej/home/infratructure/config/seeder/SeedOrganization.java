package com.melcej.home.infratructure.config.seeder;

import com.melcej.home.infratructure.database.entity.OrganizationEntity;
import com.melcej.home.infratructure.database.repository.spring.IOrganizationSpringRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Log
@Configuration
@Profile("default")
public class SeedOrganization {

  @Autowired
  protected IOrganizationSpringRepository organizationSpringRepository;

  @Bean
  CommandLineRunner initOrganizationData() {
    return args -> {
      log.info("Loading initial Organization in Database...");
      createOrganization();
    };
  }

  private void createOrganization() {
    organizationSpringRepository.save(buildOrganization());
  }

  private OrganizationEntity buildOrganization() {
    return OrganizationEntity.builder()
        .name("MELCEJ Viajes")
        .email("melcejviajes@gmail.com")
        .address("Fleming 91, Rvia, Mza")
        .aboutUsText("Empresa de viajes y turismo")
        .facebookUrl("https://www.facebook.com/melcejviajes")
        .instagramUrl("https://www.instagram.com/melcejviajes")
        .phone("+54 263 4445360")
        .build();
  }

}
