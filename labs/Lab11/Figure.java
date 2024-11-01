// Figure Class
class Figure {
    String name;
    double dim1, dim2;

    // Constructor
    Figure(String name, double dim1, double dim2) {
        this.name = name;
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    // Method to calculate area
    double getArea() {
        if(name.equals("Rectangle")) {
            return dim1 * dim2;
        } else if(name.equals("Triangle") || name.equals("Rhombus")) {
            return dim1 * dim2 / 2;
        } else {
            return -1;
        }
    }
}

