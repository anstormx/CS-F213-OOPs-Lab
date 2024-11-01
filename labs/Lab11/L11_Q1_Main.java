import java.util.*;

// L11_Q1_Main Class
public class L11_Q1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Figure[] figures = new Figure[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            double dim1 = scanner.nextDouble();
            double dim2 = scanner.nextDouble();
            figures[i] = new Figure(name, dim1, dim2);
        }

        FigureManager manager = new FigureManager(figures);
        manager.countFigures();
        manager.findLargestAreas();
        manager.countFiguresByArea();
        manager.replaceFigures();
        manager.calculateAverageAreas();
    }
}

