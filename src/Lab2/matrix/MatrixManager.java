package Lab2.matrix;

import Lab2.utils.InputUtils;

public class MatrixManager{
    /*Задание 12
    Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.*/
    public static int[][] removeRawsAndColsWithMaxEll(int [][] matrix){
        int maxEll = Integer.MIN_VALUE;
        for (int i = 0; i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                 if(matrix[i][j]>maxEll) maxEll = matrix[i][j];
            }
        }
        boolean [] rowsToDelete = new boolean [matrix.length];
        boolean [] colsToDelete = new boolean [matrix[0].length];

        for (int i = 0; i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==maxEll) {
                    rowsToDelete[i] = true;
                    colsToDelete[j] = true;
                }
            };
        }

        int newRows = 0;
        for (int i = 0; i < rowsToDelete.length; i++) {
            if (!rowsToDelete[i]) {
                newRows++;
            }
        }

        int newCols = 0;
        for (int j = 0; j < colsToDelete.length; j++) {
            if (!colsToDelete[j]) {
                newCols++;
            }
        }

        int[][] newMatrix = new int[newRows][newCols];

        int newRawIndex=0;
        int newColIndex = 0;
        for (int i = 0; i<matrix.length;i++) {
            if(rowsToDelete[i]) continue;

            for (int j = 0; j < matrix[0].length; j++){
                if(colsToDelete[j]) continue;
                newMatrix[newRawIndex][newColIndex] = matrix[i][j];
                newColIndex++;
            }
            newRawIndex++;
        }
                return newMatrix;
    }

    /*Задание 2*/
    /*Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).*/

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    };

    public static int[][] shiftMatrix(int[][] matrix,int k,Direction direction){
        switch (direction) {
            case RIGHT:
                return shiftRight(matrix, k);
            case LEFT:
                return shiftLeft(matrix, k);
            case UP:
                return shiftUp(matrix, k);
            case DOWN:
                return shiftDown(matrix, k);
            default:
                return matrix;
        }
    }

    public static int[][] shiftRight(int[][] matrix,int shifts){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [][] shiftedMatrix = new int[rows][cols];
        shifts%=cols;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int newCol = (j+shifts)%cols;
                shiftedMatrix[i][newCol]= matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    public static int[][] shiftLeft(int[][] matrix, int shifts) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][cols];

        shifts %= cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int newCol = (j - shifts + cols) % cols;
                shiftedMatrix[i][newCol] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    public static int[][] shiftUp(int[][] matrix, int shifts) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][cols];

        shifts %= rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int newRow = (i - shifts + rows) % rows;
                shiftedMatrix[newRow][j] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    public static int[][] shiftDown(int[][] matrix, int shifts) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][cols];

        shifts %= rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int newRow = (i + shifts) % rows;
                shiftedMatrix[newRow][j] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }
}