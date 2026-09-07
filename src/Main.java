import java.math.BigInteger;
import java.util.Scanner;
class Program {

    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = scanner.nextInt();
        System.out.printf("Your number: %d \n", num);
        scanner.close();

        int i = CountDigits.countLessThanFive(num);
        System.out.println("Number of digits less than five: " + i);*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа (по одному, для завершения нажмите Ctrl+D / Ctrl+Z или введите 'exit'):");

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