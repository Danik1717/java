package Lab2.utils;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputUtils {

    private static int inputMatrixSize(Scanner scanner) {
        System.out.print("Enter n (the size of matrix nxn): ");
        return scanner.nextInt();
    }

    public static int[][] createAndFillMatrix(Scanner scanner) {
        int n = inputMatrixSize(scanner);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] createAndFillRandomMatrix(Scanner scanner) {
        int n = inputMatrixSize(scanner);
        int[][] matrix = new int[n][n];
        int max = 100;
        int min = -100;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * (max - min + 1)) + min;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}