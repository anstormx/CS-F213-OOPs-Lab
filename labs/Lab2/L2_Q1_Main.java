import java.util.Scanner;

public class L2_Q1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        int n = scanner.nextInt();
        int[] inputArr = new int[n];

        // Read the elements of the array
        for (int i = 0; i < n; i++) {
            inputArr[i] = scanner.nextInt();
        }

        // Call the solve method from the L2_Q1_Soln class
        L2_Q1_Soln.solve(inputArr);

        scanner.close();
    }
}
