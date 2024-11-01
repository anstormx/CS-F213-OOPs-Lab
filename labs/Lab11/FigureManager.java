import java.util.*;

class FigureManager {
    Figure[] figures;

    FigureManager(Figure[] figures) {
        this.figures = figures;
    }

    void countFigures() {
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("Triangle", 0);
        countMap.put("Rectangle", 0);
        countMap.put("Rhombus", 0);

        for (Figure figure : figures) {
            countMap.put(figure.name, countMap.get(figure.name) + 1);
        }

        System.out.println("Figure counts:");
        System.out.println("Triangles: " + countMap.get("Triangle"));
        System.out.println("Rectangles: " + countMap.get("Rectangle"));
        System.out.println("Rhombuses: " + countMap.get("Rhombus"));
    }

    void findLargestAreas() {
        Map<String, Double> largestAreaMap = new HashMap<>();
        largestAreaMap.put("Triangle", -1.0);
        largestAreaMap.put("Rectangle", -1.0);
        largestAreaMap.put("Rhombus", -1.0);

        for (Figure figure : figures) {
            double currentArea = figure.getArea();
            double existingMax = largestAreaMap.get(figure.name);
            largestAreaMap.put(figure.name, Math.max(currentArea, existingMax));
        }

        System.out.println("Largest areas:");
        System.out.println("Triangle: " + largestAreaMap.get("Triangle"));
        System.out.println("Rectangle: " + largestAreaMap.get("Rectangle"));
        System.out.println("Rhombus: " + largestAreaMap.get("Rhombus"));
    }

    void countFiguresByArea() {
        Map<Double, Integer> areaCountMap = new HashMap<>();

        for (Figure figure : figures) {
            double area = figure.getArea();
            areaCountMap.put(area, areaCountMap.getOrDefault(area, 0) + 1);
        }

        System.out.println("Figures with area 20.0: " + areaCountMap.getOrDefault(20.0, 0));
        System.out.println("Figures with area 30.0: " + areaCountMap.getOrDefault(30.0, 0));
    }

    void replaceFigures() {
        Map<Double, Figure> areaMap = new HashMap<>();

        for (Figure figure : figures) {
            double area = figure.getArea();
            if (!areaMap.containsKey(area)) {
                areaMap.put(area, figure);
            } else {
                Figure existing = areaMap.get(area);
                if (shouldReplace(existing, figure)) {
                    areaMap.put(area, figure);
                }
            }
        }

        // Check for area 20.0
        System.out.println("Figure with area 20.0: " + 
            (areaMap.containsKey(20.0) ? areaMap.get(20.0).name : "Key not present."));
            
        // Check for area 30.0
        if (areaMap.containsKey(30.0)) {
            Figure figure = areaMap.get(30.0);
            System.out.println("Figure with area 30.0: " + figure.name);
        } else {
            boolean found = false;
            // Find any figure with area 30.0
            for (Figure figure : figures) {
                if (Math.abs(figure.getArea() - 30.0) < 0.0001) {
                    System.out.println("Figure with area 30.0: " + figure.name);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Figure with area 30.0: Key not present.");
            }
        }
    }

    private boolean shouldReplace(Figure existing, Figure newFigure) {
        if (newFigure.name.equals("Rhombus")) {
            return true;
        }
        if (newFigure.name.equals("Rectangle")) {
            return !existing.name.equals("Rhombus");
        }
        if (newFigure.name.equals("Triangle")) {
            return existing.name.equals("Triangle");
        }
        return false;
    }

    void calculateAverageAreas() {
        Map<String, Double> totalAreaMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Figure figure : figures) {
            totalAreaMap.put(figure.name, totalAreaMap.getOrDefault(figure.name, 0.0) + figure.getArea());
            countMap.put(figure.name, countMap.getOrDefault(figure.name, 0) + 1);
        }

        System.out.println("Average areas:");
        printAverage("Triangle", totalAreaMap, countMap);
        printAverage("Rectangle", totalAreaMap, countMap);
        printAverage("Rhombus", totalAreaMap, countMap);
    }

    private void printAverage(String type, Map<String, Double> totalAreaMap, Map<String, Integer> countMap) {
        if (countMap.containsKey(type) && countMap.get(type) > 0) {
            double average = totalAreaMap.get(type) / countMap.get(type);
            System.out.println(type + ": " + average);
        }
    }
}