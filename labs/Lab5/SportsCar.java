/**
 * Represents a SportsCar, which is a specific type of Car.
 * This class inherits from the Car class and overrides its abstract methods.
 * Complete the class definition to inherit the car class
 */
public class SportsCar extends Car {
    public SportsCar(int fuel) {
        super("SportsCar", 70, 4, fuel);
    }

    public void brake() {
        if (fuel != 0) {
            super.speed -= 5;
        }
    }

    public void accelerate() {
        if (fuel != 0) {
            super.speed += 20;
        }
    }
}