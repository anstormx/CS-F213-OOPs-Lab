// File: Main.java
import java.util.Scanner;

public class L1_Q1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        // Call the solve method from the StudentSolution class
        L1_Q1_Soln.solve(number);

        scanner.close();
    }
}
