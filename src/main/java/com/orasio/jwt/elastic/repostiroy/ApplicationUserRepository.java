package com.orasio.jwt.elastic.repostiroy;

import com.orasio.jwt.elastic.domain.ApplicationUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationUserRepository extends ElasticsearchRepository<ApplicationUser, String> {
    ApplicationUser findByUsername(String username);
}
