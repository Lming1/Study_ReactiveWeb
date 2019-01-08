package com.raphael.Study_ReactiveWeb;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@WebFluxTest
@Import(value = HelloHandler.class)
public class HelloControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void router() {
        Hello responseBody = webTestClient.get().uri("/test").exchange()
                .expectStatus().isOk()
                .expectBody(Hello.class)
                .returnResult().getResponseBody();

        assertThat(responseBody.getId()).isEqualTo(1);
        assertThat(responseBody.getTitle()).isEqualTo("hello");
        assertThat(responseBody.getMessage()).isEqualTo("test");
    }

    @Test
    public void failExecutePostMethodTest() {
        webTestClient.post().uri("/test").exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
}
