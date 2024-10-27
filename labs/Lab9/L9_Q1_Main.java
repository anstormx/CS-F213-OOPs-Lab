import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L9_Q1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the number of rectangles
        int numRectangles = scanner.nextInt();

        // Step 2: Initialize a list to store the rectangles
        List<Rectangle> rectangles = new ArrayList<>();

        // Step 3: Read dimensions and create Rectangle objects
        for (int i = 0; i < numRectangles; i++) {
            double width = scanner.nextDouble();
            double height = scanner.nextDouble();
            rectangles.add(new Rectangle(width, height, i));
        }

        // Step 4: Analyze the rectangles
        RectangleManager.analyzeRectangles(rectangles);

        scanner.close();
    }
}
