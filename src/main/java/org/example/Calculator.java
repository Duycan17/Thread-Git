package org.example;

public class Calculator {
    private int a;
    private int b;
    private boolean inputComplete = false;

    public synchronized void setInput(int a, int b) {
        this.a = a;
        this.b = b;
        this.inputComplete = true;
        notifyAll();
    }

    public synchronized int calculateSum() {
        while (!inputComplete) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return a + b;
    }
}