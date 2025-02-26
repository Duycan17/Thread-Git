package org.example;

public class Calculator {
    private int a;
    private int b;
    private boolean inputComplete = false;

    public void setInput(int a, int b) {
        this.a = a;
        this.b = b;
        this.inputComplete = true;
    }

    public int calculateSum() {
        return a + b;
    }

    public boolean isInputComplete() {
        return inputComplete;
    }
}