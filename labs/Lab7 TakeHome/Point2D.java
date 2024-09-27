public class Point2D {
    // Fields
    private int x;
    private int y;

    // Constructor
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter Methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Moves the point to a new location
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
