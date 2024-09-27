import java.util.Scanner;

public class L3_Q1_Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        int n = scanner.nextInt();
        Car[] carArray = new Car[n];

        // Read the elements of the array
        for (int i = 0; i < n; i++) {
            
            int horsepower = scanner.nextInt(); 
            int fuel = scanner.nextInt(); 
            double mileage = scanner.nextDouble(); 
    
            Car c = new Car(horsepower, fuel, mileage);
            carArray[i] = c;
        }
        
        for (int i = 0; i < n; i++) {
            L3_Q1_Soln.solve(carArray[i]);
        }

        scanner.close();
    }
}