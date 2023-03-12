package com.gringrape.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/greet")
public class HelloController {

    @GetMapping
    public Mono<String> hello() {
        return Mono.create(sink -> {
            sink.success("Hello, World!");
        });
    }

}
