package org.example;
import java.util.Scanner;

public class Multithread {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Thread 1 - Input thread
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter value for a:");
            int a = scanner.nextInt();
            System.out.println("Enter value for b:");
            int b = scanner.nextInt();
            calculator.setInput(a, b);
            System.out.println("Input thread finished");
            scanner.close();
        });

        // Thread 2 - First calculator thread
        Thread calc1 = new Thread(() -> {
            System.out.println("Calculator thread 1 waiting for input...");
            int sum = calculator.calculateSum();
            System.out.println("Calculator thread 1 result: " + sum);
        });

        // Thread 3 - Second calculator thread
        Thread calc2 = new Thread(() -> {
            System.out.println("Calculator thread 2 waiting for input...");
            int sum = calculator.calculateSum();
            System.out.println("Calculator thread 2 result: " + sum);
        });

        // Start all threads
        inputThread.start();
        calc1.start();
        calc2.start();
    }
}