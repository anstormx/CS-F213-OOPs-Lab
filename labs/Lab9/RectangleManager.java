import java.util.*;

public class RectangleManager {
    public static void analyzeRectangles(List<Rectangle> rectangles) {
        Rectangle rectangle0 = rectangles.get(0);
        
        // First Output: Maximum number of rectangles that can fit inside Rectangle 0
        int maxFitInside = countRectanglesFittingInside(rectangle0, rectangles);
        System.out.println(maxFitInside);
        
        // Second Output: Maximum number of rectangles that Rectangle 0 can fit into
        int maxContaining = countRectanglesContaining(rectangle0, rectangles);
        System.out.println(maxContaining);
        
        // Third Output: Index of Rectangle with the closest aspect ratio to Rectangle 0
        int closestAspectRatioIndex = findClosestAspectRatio(rectangle0, rectangles);
        System.out.println(closestAspectRatioIndex);
        
        // Fourth Output: Maximum number of rectangles that can be nested
        int maxNested = findMaxNestedRectangles(rectangles);
        System.out.println(maxNested);
    }

    public static int countRectanglesFittingInside(Rectangle rect, List<Rectangle> rectangles) {
        int count = 0;
        for (int i = 1; i < rectangles.size(); i++) {
            if (rectangles.get(i).canFitInside(rect)) {
                count++;
            }
        }
        return count;
    }

    public static int countRectanglesContaining(Rectangle rect, List<Rectangle> rectangles) {
        int count = 0;
        for (int i = 1; i < rectangles.size(); i++) {
            if (rect.canFitInside(rectangles.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static int findClosestAspectRatio(Rectangle reference, List<Rectangle> rectangles) {
        double refRatio = reference.getAspectRatio();
        double minDiff = Double.MAX_VALUE;
        int closestIndex = 0;

        for (int i = 1; i < rectangles.size(); i++) {
            Rectangle rect = rectangles.get(i);
            double ratio = rect.getAspectRatio();
            double invertedRatio = 1 / ratio;
            
            double diff1 = Math.abs(refRatio - ratio);
            double diff2 = Math.abs(refRatio - invertedRatio);
            
            double minCurrentDiff = Math.min(diff1, diff2);
            
            if (minCurrentDiff < minDiff) {
                minDiff = minCurrentDiff;
                closestIndex = i;
            }
        }
        
        return closestIndex;
    }

    public static int findMaxNestedRectangles(List<Rectangle> rectangles) {
        // Sort rectangles based on area 
        Collections.sort(rectangles);
        
        int n = rectangles.size();
        int[] dp = new int[n];  // dp[i] will store the maximum number of rectangles that can be nested up to i
        Arrays.fill(dp, 1);  // Every rectangle can fit at least itself

        // Iterate through each rectangle and try to nest it into previous ones
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (canFit(rectangles.get(j), rectangles.get(i))) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // Return the maximum value from dp array, which gives the max nested rectangles
        int maxNested = 1;
        for (int i = 0; i < n; i++) {
            maxNested = Math.max(maxNested, dp[i]);
        }
        
        return maxNested;
    }

    private static boolean canFit(Rectangle r1, Rectangle r2) {
        boolean fitsNoRotation = (r1.getWidth() <= r2.getWidth() && r1.getHeight() <= r2.getHeight());
        boolean fitsWithRotation = (r1.getWidth() <= r2.getHeight() && r1.getHeight() <= r2.getWidth());
        return fitsNoRotation || fitsWithRotation;
    }
}