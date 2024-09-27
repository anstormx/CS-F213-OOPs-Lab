/**
 * Represents a SUV, which is a specific type of Car.
 * This class inherits from the Car class and overrides its abstract methods.
 * Complete the class definition to inherit the car class
 */
public class SUV extends Car {
    public SUV(int fuel) {
        super("SUV", 40, 3, fuel);
    }

    public void brake() {
        if (fuel != 0) {
            super.speed -= 15;
        }
    }

    public void accelerate() {
        if (fuel != 0) {
            super.speed += 5;
        }
    }
}