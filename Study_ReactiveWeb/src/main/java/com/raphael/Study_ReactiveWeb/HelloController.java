package com.raphael.Study_ReactiveWeb;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<Hello> hello() {
        Hello hello = new Hello();
        hello.setTitle("hello");
        hello.setMessage("test");
        return Mono.just(hello);
    }
}
