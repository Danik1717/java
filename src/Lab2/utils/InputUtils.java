package Lab2.utils;

import java.util.Scanner;

public class InputUtils{

    public static int[][] createAndFillMatrix(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter number of rows and columns: ");
        int rows =  scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];


        for(int i = 0; i<rows;i++){
            for(int j = 0; j<cols;j++){
                System.out.print("[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int [][] matrix){
        for (int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int inputNumOfShifts(Scanner scanner){
        System.out.println("Enter number of shifts: ");

        int k = scanner.nextInt();

        return k;
    }
}