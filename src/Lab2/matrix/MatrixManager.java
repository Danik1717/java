package Lab2.matrix;

public class MatrixManager implements IMatrixManager {

    /* Задание 12
       Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие. */
    @Override
    public int[][] removeRawsAndColsWithMax(int[][] matrix) {
        int maxEll = Integer.MIN_VALUE;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] > maxEll) maxEll = ints[j];
            }
        }

        boolean[] rowsToDelete = new boolean[matrix.length];
        boolean[] colsToDelete = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == maxEll) {
                    rowsToDelete[i] = true;
                    colsToDelete[j] = true;
                }
            }
        }

        int newRows = 0;
        for (boolean b : rowsToDelete) {
            if (!b) {
                newRows++;
            }
        }

        int newCols = 0;
        for (boolean b : colsToDelete) {
            if (!b) {
                newCols++;
            }
        }

        int[][] newMatrix = new int[newRows][newCols];

        int newRawIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (rowsToDelete[i]) continue;

            int newColIndex = 0; // FIXED: Must reset to 0 for every new row!
            for (int j = 0; j < matrix[0].length; j++) {
                if (colsToDelete[j]) continue;
                newMatrix[newRawIndex][newColIndex] = matrix[i][j];
                newColIndex++;
            }
            newRawIndex++;
        }
        return newMatrix;
    }

    /* Задание 2
       Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз). */
    @Override
    public int[][] shiftMatrix(int[][] matrix, int k, Direction direction) {
        return switch (direction) {
            case RIGHT -> shiftRight(matrix, k);
            case LEFT -> shiftLeft(matrix, k);
            case UP -> shiftUp(matrix, k);
            case DOWN -> shiftDown(matrix, k);
            default -> matrix;
        };
    }

    @Override
    public int[][] shiftRight(int[][] matrix, int shifts) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][cols];
        shifts %= cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int newCol = (j + shifts) % cols;
                shiftedMatrix[i][newCol] = matrix[i][j];
            }
        }
        return shiftedMatrix;
    }

    @Override
    public int[][] shiftLeft(int[][] matrix, int shifts) {
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

    @Override
    public int[][] shiftUp(int[][] matrix, int shifts) {
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

    @Override
    public int[][] shiftDown(int[][] matrix, int shifts) {
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