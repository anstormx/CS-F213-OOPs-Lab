/**
 * Represents a Sedan, which is a specific type of Car.
 * This class inherits from the Car class and overrides its abstract methods.
 * Complete the class definition to inherit the car class
 */
public class Sedan extends Car {
    // Write the members
    public Sedan(int fuel) {
        super("Sedan", 50, 2, fuel);
    }

    public void brake() {
        if (fuel != 0) {
            super.speed -= 10;
        }
    }

    public void accelerate() {
        if (fuel != 0) {
            super.speed += 10;
        }
    }
}
