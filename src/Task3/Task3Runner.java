package Task3;

import java.util.Scanner;

public class Task3Runner {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите последовательность чисел:");
        String line = scanner.nextLine();

        String [] numbers = line.strip().split("\\s+");
        scanner.close();

        int[] globalSeq = Task3Utils.countNumberInEntireSequence(numbers);
        System.out.print("\nОбщая статистика по всем числам с чётной длиной: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ":" + globalSeq[i] + " ");
        }
        System.out.println();
    }
}
