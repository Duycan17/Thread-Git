package org.example.ex6;

import java.util.Scanner;

public class MatrixMultiplication {
    private static final int N = 3; // Kích thước của ma trận

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        int[][] matrixA = new int[N][N];
        int[][] matrixB = new int[N][N];
        int[][] resultMatrix = new int[N][N];

        System.out.println("Nhập ma trận A:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Nhập ma trận B:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        Thread[][] threads = new Thread[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                final int row = i;
                final int col = j;
                threads[i][j] = new Thread(() -> {
                    resultMatrix[row][col] = 0;
                    for (int k = 0; k < N; k++) {
                        resultMatrix[row][col] += matrixA[row][k] * matrixB[k][col];
                    }
                });
                threads[i][j].start();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                threads[i][j].join();
            }
        }

        System.out.println("Ma trận kết quả:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}