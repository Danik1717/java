package Lab2.matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamMatrixManager implements IMatrixManager {

    @Override
    public int[][] removeRawsAndColsWithMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        int maxEll = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(Integer.MIN_VALUE);

        boolean[] rowsToDelete = new boolean[matrix.length];
        boolean[] colsToDelete = new boolean[matrix[0].length];

        IntStream.range(0, matrix.length).forEach(i ->
                IntStream.range(0, matrix[0].length)
                        .filter(j -> matrix[i][j] == maxEll)
                        .forEach(j -> {
                            rowsToDelete[i] = true;
                            colsToDelete[j] = true;
                        })
        );

        return IntStream.range(0, matrix.length)
                .filter(i -> !rowsToDelete[i])
                .mapToObj(r -> IntStream.range(0, matrix[0].length)
                        .filter(j -> !colsToDelete[j])
                        .map(c -> matrix[r][c])
                        .toArray())
                .toArray(int[][]::new);
    }

    @Override
    public int[][] shiftMatrix(int[][] matrix, int k, Direction direction) {
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

    @Override
    public int[][] shiftRight(int[][] matrix, int shifts) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int cols = matrix[0].length;
        int s = ((shifts % cols) + cols) % cols;

        return Arrays.stream(matrix)
                .map(row -> IntStream.range(0, cols)
                        .map(c -> row[(c - s + cols) % cols])
                        .toArray())
                .toArray(int[][]::new);
    }

    @Override
    public int[][] shiftLeft(int[][] matrix, int shifts) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int cols = matrix[0].length;
        int s = ((shifts % cols) + cols) % cols;

        return Arrays.stream(matrix)
                .map(row -> IntStream.range(0, cols)
                        .map(c -> row[(c + s) % cols])
                        .toArray())
                .toArray(int[][]::new);
    }

    @Override
    public int[][] shiftUp(int[][] matrix, int shifts) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int rows = matrix.length;
        int s = ((shifts % rows) + rows) % rows;

        return IntStream.range(0, rows)
                .mapToObj(r -> matrix[(r + s) % rows])
                .toArray(int[][]::new);
    }

    @Override
    public int[][] shiftDown(int[][] matrix, int shifts) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int rows = matrix.length;
        int s = ((shifts % rows) + rows) % rows;

        return IntStream.range(0, rows)
                .mapToObj(r -> matrix[(r - s + rows) % rows])
                .toArray(int[][]::new);
    }
}