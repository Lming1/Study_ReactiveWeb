package com.raphael.Study_ReactiveWeb;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Component
public class HelloHandler {
    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        Mono<Hello> helloMono = Mono.just(new Hello(1, "hello", "test"));
        return ServerResponse.ok().body(helloMono, Hello.class);
    }
}




