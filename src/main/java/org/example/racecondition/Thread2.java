package org.example.racecondition;

public class Thread2 implements Runnable {
    private final Container container;

    public Thread2(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            container.incrementA();
        }
    }
}