package Lab2;

import Lab2.matrix.IMatrixManager;
import Lab2.matrix.MatrixManager;
import Lab2.matrix.StreamMatrixManager;
import Lab2.utils.MenuHandler;

import java.util.Scanner;

public class Main {


    static void main() {
        Scanner scanner = new Scanner(System.in);

        // 1. Ask which version to run
        System.out.println("Select implementation:");
        System.out.println("1. Classic Loops ");
        System.out.println("2. Stream API ");
        System.out.print("Choice: ");
        int implChoice = 1;
        if (scanner.hasNextInt()) {
            implChoice = scanner.nextInt();
        }

        IMatrixManager manager;
        if (implChoice == 2) {
            manager = new StreamMatrixManager();
            System.out.println("--- Stream API Selected ---");
        } else {
            manager = new MatrixManager();
            System.out.println("--- Classic Loops Selected ---");
        }

        MenuHandler.setMatrixManager(manager);

        while (true) {
            System.out.println("\n1. Find max element(s) and delete their rows/columns");
            System.out.println("2. Cyclic shift of the matrix");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        MenuHandler.handleFindMaxAndDelete(scanner);
                        break;
                    case 2:
                        MenuHandler.handleCyclicShift(scanner);
                        break;
                    case 0:
                        System.out.println("The program was finished.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please select 0, 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input, enter a number.");
                scanner.next();
            }
        }
    }
}