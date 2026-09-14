package Lab2.utils;

import Lab2.matrix.MatrixManager;

import java.util.Scanner;

public class MenuHandler {

    public static void handleCyclicShift(Scanner scanner) {
        int[][] matrixToShift = InputUtils.createAndFillMatrix();
        System.out.println("Original Matrix:");
        InputUtils.printMatrix(matrixToShift);

        System.out.print("Enter the number of positions to shift: ");
        int shifts = scanner.nextInt();

        System.out.println("Choose direction: 1-UP, 2-DOWN, 3-LEFT, 4-RIGHT");
        System.out.print("Direction choice: ");
        int dirChoice = scanner.nextInt();

        MatrixManager.Direction direction;
        switch (dirChoice) {
            case 1: direction = MatrixManager.Direction.UP; break;
            case 2: direction = MatrixManager.Direction.DOWN; break;
            case 3: direction = MatrixManager.Direction.LEFT; break;
            case 4: direction = MatrixManager.Direction.RIGHT; break;
            default:
                System.out.println("Invalid direction! Defaulting to RIGHT.");
                direction = MatrixManager.Direction.RIGHT;
        }

        int[][] shifted = MatrixManager.shiftMatrix(matrixToShift, shifts, direction);
        System.out.println("Shifted Matrix:");
        InputUtils.printMatrix(shifted);
    }

    public static void handleFindMaxAndDelete(Scanner scanner) {
        int [][] matrix = InputUtils.createAndFillMatrix();
        System.out.println("Original matrix:");
        scanner.nextLine();
        InputUtils.printMatrix(matrix);
        int [][] newMatrix = MatrixManager.removeRawsAndColsWithMaxEll(matrix);
        System.out.println("New matrix:");
        InputUtils.printMatrix(newMatrix);
    }
}
