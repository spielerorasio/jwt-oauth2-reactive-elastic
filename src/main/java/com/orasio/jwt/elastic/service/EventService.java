package com.orasio.jwt.elastic.service;

import com.orasio.jwt.elastic.domain.Event;
import reactor.core.publisher.Flux;

public interface EventService {
    Flux<Event> findAll();
}
