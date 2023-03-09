package com.gringrape.codechecker;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private final CountDownLatch messageReceivedSignal = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        messageReceivedSignal.countDown();
    }

    public CountDownLatch getLatch() {
        return messageReceivedSignal;
    }

}
