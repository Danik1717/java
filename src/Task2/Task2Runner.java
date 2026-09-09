package Task2;

import java.util.Scanner;
import java.math.BigInteger;

public class Task2Runner {
   static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите последовательность чисел:");

        while (scanner.hasNextBigInteger()) {
            BigInteger num = scanner.nextBigInteger();
            String result = GetReverseNumber.processNumber(num);
            if (!result.isEmpty()) {
                System.out.print(result + " ");
            }
        }
        scanner.close();
    }
}
