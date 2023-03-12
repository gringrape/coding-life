package com.gringrape.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {

    private WebClient client;

    @BeforeEach
    void setup() {
        client = WebClient.create("http://localhost:8080");
    }

    @Test
    void greetWithGreetingMessage() {
        Mono<String> stringMono = client.get()
                .uri("/greet")
                .retrieve()
                .bodyToMono(String.class);

        String message = stringMono.block();

        assertEquals("Hello, World!", message);
    }

}
