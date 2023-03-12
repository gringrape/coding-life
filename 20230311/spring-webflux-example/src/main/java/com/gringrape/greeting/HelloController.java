package com.gringrape.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/greet")
public class HelloController {

    @GetMapping
    public Mono<String> hello() {
        return checkCode().all(i -> i)
                .map(i -> i ? "Success" : "Failure");
    }

    private Flux<Boolean> checkCode() {
        return Flux.just(true, true, true)
                .doOnNext(sink -> {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .onErrorReturn(false);
    }
}
