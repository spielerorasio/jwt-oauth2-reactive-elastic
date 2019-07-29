package com.orasio.jwt.elastic.service;

import com.orasio.jwt.elastic.domain.ApplicationUser;
import com.orasio.jwt.elastic.domain.Role;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ApplicationUserService {
    Mono<ApplicationUser> findByUsername(String username);

    void addUser(String username, String password, List<Role> roles);
}
