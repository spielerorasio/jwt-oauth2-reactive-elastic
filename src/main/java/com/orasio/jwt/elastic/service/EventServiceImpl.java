package com.orasio.jwt.elastic.service;

import com.orasio.jwt.elastic.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j //Causes lombok to generate a logger field.
public class EventServiceImpl implements EventService {
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Flux<Event> findAll() {
        log.info("works with lombok");
        List<Event> events = Collections.singletonList(new Event("event 1", System.currentTimeMillis()));

        return Flux.fromStream(events.stream());
    }
}
