package Task1;
import java.util.Scanner;
public class Task1Runner {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = scanner.nextInt();
        System.out.printf("Your number: %d \n", num);
        scanner.close();

        int i = Task1.CountDigits.countLessThanFive(num);
        System.out.print("Number of digits less than five: " + i);
    }
}
