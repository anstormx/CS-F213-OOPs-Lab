public class Circle extends Shape   // A Circle "is-a" Shape
{
    // Each Circle "has-a" Point2D, inherited from its parent
    private int radius;

    public Circle(int x, int y, int radius)  // Constructor
    {
        super(x, y);
        this.radius = radius;
    }
    public Circle(Point2D centre, int radius)   // Overloaded Constructor
    {
        super(centre);
        this.radius = radius;
    }

    // Methods
    public int getRadius()  // Return the radius of the Circle
    {
        return radius;
    }
    public double getArea()     // Override the inherited method, Return the Area of the Circle
    {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter()    // Override the inherited method, Return the Perimeter of the Circle
    {
        return 2 * Math.PI * radius;
    }
    public boolean withinCircle(Point2D point)  // Return true if the point lies within the Circle
    {
        return Math.pow(point.getX() - getCentre().getX(), 2) + Math.pow(point.getY() - getCentre().getY(), 2) <= Math.pow(radius, 2);
    }
}