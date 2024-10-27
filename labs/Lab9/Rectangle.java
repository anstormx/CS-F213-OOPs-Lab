// Rectangle.java

public class Rectangle extends Figure implements Comparable<Rectangle> {
    private double width;
    private double height;
    private int index; // To identify the rectangle

    // Constructor
    public Rectangle(double width, double height, int index) {
        this.width = width;
        this.height = height;
        this.index = index;
    }

    // Getters
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getIndex() {
        return index;
    }

    public double getAspectRatio() {
        return width / height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public int compareTo(Rectangle o) {
        return Double.compare(this.getArea(), o.getArea());
    }

    public boolean canFitInside(Rectangle other) {
        return (this.width <= other.width && this.height <= other.height) ||
                (this.width <= other.height && this.height <= other.width);
    }

    public boolean canContain(Rectangle other) {
        return other.canFitInside(this);
    }
}
