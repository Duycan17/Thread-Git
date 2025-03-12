package org.example.ex7;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        final int[] results = new int[3];

        // Thread 1 - Calculate n!
        Thread factorialThread = new Thread(() -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            results[0] = result;
            System.out.println("Factorial of " + n + " is: " + result);
        });

        // Thread 2 - Calculate sum from 1 to n
        Thread sumThread = new Thread(() -> {
            int result = 0;
            for (int i = 1; i <= n; i++) {
                result += i;
            }
            results[1] = result;
            System.out.println("Sum from 1 to " + n + " is: " + result);
        });

        // Thread 3 - Calculate sum of even numbers from 1 to n-1
        Thread evenSumThread = new Thread(() -> {
            int result = 0;
            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) {
                    result += i;
                }
            }
            results[2] = result;
            System.out.println("Sum of even numbers from 1 to " + (n - 1) + " is: " + result);
        });

        // Start all threads
        factorialThread.start();
        sumThread.start();
        evenSumThread.start();

        // Wait for all threads to finish
        factorialThread.join();
        sumThread.join();
        evenSumThread.join();

        // Sum the results
        int totalSum = results[0] + results[1] + results[2];
        System.out.println("Total sum of all results is: " + totalSum);
    }
}