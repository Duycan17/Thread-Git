package org.example.ex1;
public class Calculator {
    private int a;
    private int b;
    private boolean inputComplete = false;

    public Calculator() {
    }

    public Calculator(int a, int b, boolean inputComplete) {
        this.a = a;
        this.b = b;
        this.inputComplete = inputComplete;
    }
    public void setInput(int a, int b){
        this.a = a;
        this.b = b;
        inputComplete = true;
    }
    public int calculateSum() {
        return a + b;
    }

    public boolean isInputComplete() {
        return inputComplete;
    }
}