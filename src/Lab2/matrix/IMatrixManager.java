package Lab2.matrix;

public interface IMatrixManager {

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    int[][] removeRawsAndColsWithMax(int[][] matrix);

    int[][] shiftMatrix(int[][] matrix, int k, Direction direction);

    int[][] shiftRight(int[][] matrix, int shifts);

    int[][] shiftLeft(int[][] matrix, int shifts);

    int[][] shiftUp(int[][] matrix, int shifts);

    int[][] shiftDown(int[][] matrix, int shifts);
}