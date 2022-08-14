package com.melcej.home.infratructure.config.spring.security;

import com.melcej.home.infratructure.database.entity.UserEntity;
import com.melcej.home.infratructure.database.repository.spring.IUserSpringRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityService implements UserDetailsService {

  @Autowired
  private IUserSpringRepository userSpringRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity = userSpringRepository.findByEmail(username);
    if (userEntity == null) {
      throw new UsernameNotFoundException("User not found.");
    }
    return userEntity;
  }

}
