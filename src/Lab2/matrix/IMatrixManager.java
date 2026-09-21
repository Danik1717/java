package Lab2.matrix;

public interface IMatrixService {
    int[][] shiftRight(int[][] matrix, int shifts);
    int[][] shiftLeft(int[][] matrix, int shifts);
    int[][] shiftUp(int[][] matrix, int shifts);
    int[][] shiftDown(int[][] matrix, int shifts);
    int[][] removeRowsAndColsWithMax(int[][] matrix);
}
