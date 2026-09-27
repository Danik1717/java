package Lab2.utils;

import Lab2.matrix.IMatrixManager;
import Lab2.matrix.MatrixManager;

import java.util.Scanner;

public class MenuHandler {

    private static IMatrixManager matrixManager = new MatrixManager();

    public static void setMatrixManager(IMatrixManager newMatrixManager){
        matrixManager= newMatrixManager;
    }

    public static void handleCyclicShift(Scanner scanner) {
        int[][] matrixToShift = InputUtils.createAndFillRandomMatrix(scanner);
        System.out.println("Original Matrix:");
        InputUtils.printMatrix(matrixToShift);

        System.out.print("Enter the number of positions to shift: ");
        int shifts = scanner.nextInt();

        System.out.println("Choose direction: 1-UP, 2-DOWN, 3-LEFT, 4-RIGHT");
        System.out.print("Direction choice: ");
        int dirChoice = scanner.nextInt();

        IMatrixManager.Direction direction;
        switch (dirChoice) {
            case 1: direction = IMatrixManager.Direction.UP; break;
            case 2: direction = IMatrixManager.Direction.DOWN; break;
            case 3: direction = IMatrixManager.Direction.LEFT; break;
            case 4: direction = IMatrixManager.Direction.RIGHT; break;
            default:
                System.out.println("Invalid direction! Defaulting to RIGHT.");
                direction = IMatrixManager.Direction.RIGHT;
        }

        int[][] shifted = matrixManager.shiftMatrix(matrixToShift, shifts, direction);
        System.out.println("Shifted Matrix:");
        InputUtils.printMatrix(shifted);
    }

    public static void handleFindMaxAndDelete(Scanner scanner) {
        int[][] matrix = InputUtils.createAndFillMatrix(scanner);
        System.out.println("Original matrix:");
        scanner.nextLine();
        InputUtils.printMatrix(matrix);

        int[][] newMatrix = matrixManager.removeRawsAndColsWithMax(matrix);

        System.out.println("New matrix:");
        InputUtils.printMatrix(newMatrix);
    }
}