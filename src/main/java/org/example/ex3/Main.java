package org.example.ex3;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int THREAD_COUNT = 7;
        Random random = new Random();
        int[] results = new int[THREAD_COUNT];
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                results[index] = random.nextInt(5) + 1;
                System.out.println("Thread " + index + " generated: " + results[index]);
            });
            threads[i].start();
            threads[i].join();
        }
        int sum = 0;
        for (int result : results) {
            sum += result;
        }

        System.out.println("Sum of random numbers: " + sum);
    }
}