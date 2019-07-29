package com.orasio.jwt.elastic.service;

import com.orasio.jwt.elastic.domain.ApplicationUser;
import com.orasio.jwt.elastic.domain.Role;
import com.orasio.jwt.elastic.repostiroy.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Override
    public Mono<ApplicationUser> findByUsername(String username) {
        return Mono.just(applicationUserRepository.findByUsername(username));
    }

    @Override
    public void addUser(String username, String password, List<Role> roles) {
        applicationUserRepository.save(new ApplicationUser(null, username, password, true, roles));

    }
}
