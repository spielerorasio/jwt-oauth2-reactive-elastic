package com.orasio.jwt.elastic.controller;

import com.orasio.jwt.elastic.domain.Event;
import com.orasio.jwt.elastic.service.EventService;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
public class EventController {
    @Autowired
    EventService eventService;
    @Autowired
    RestHighLevelClient restHighLevelClient ;//non-blocking HTTP client

    @GetMapping("/events")
//    @PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Flux<Event> findAll() {
        //restHighLevelClient.
        return this.eventService.findAll();
    }

//    @GetMapping("/hello")
//    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
//        return serverRequest.principal()
//                .map(Principal::getName)
//                .flatMap(username ->
//                        ServerResponse.ok()
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .syncBody(Collections.singletonMap("message", "Hello " + username + "!"))
//                );
//    }

    @GetMapping("/")
    @PreAuthorize("hasRole('USER')")
    public Mono<Map<String, String>> hello(Mono<Principal> principal) {
        return principal
                .map(Principal::getName)
                .map(this::helloMessage);
    }
    private Map<String, String> helloMessage(String username) {
        return Collections.singletonMap("message", "Hello " + username + "!");
    }
}
