package Lab2;

import Lab2.matrix.MatrixManager;
import Lab2.utils.InputUtils;
import Lab2.utils.MenuHandler;

import java.util.Scanner;

public class Main{
    static void main() {
        while(true){
            System.out.println("1. Find max element(s) and delete their rows/columns");
            System.out.println("2. Cyclic shift of the matrix");
            System.out.println("3. Swap min element with a specific position");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()){
                int choice = scanner.nextInt();
                switch (choice) {
                    case (1):
                        MenuHandler.handleFindMaxAndDelete(scanner);
                        break;
                    case (2):
                        MenuHandler.handleCyclicShift(scanner);
                        break;
                    case (3):

                        break;
                    case (0):
                        System.out.print("The program was finished");

                        return;
                    default:
                        System.out.println("Invalid choice. Please select 0, 1, 2, or 3.");
                }
            }else{
                System.out.print("Invalid input, enter the correct option");
                scanner.nextLine();
            }
        }
    }


}