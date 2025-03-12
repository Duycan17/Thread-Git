package org.example.racecondition;

public class Thread1 extends Thread {
    private final Container container;

    public Thread1(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            container.incrementA();
        }
    }
}