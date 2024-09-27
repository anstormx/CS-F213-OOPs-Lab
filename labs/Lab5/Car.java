public abstract class Car {
    protected String model;
    protected int speed;
    protected int fuelConsumption;
    protected int fuel;
    protected int distanceCovered;

    public Car(String model, int speed, int fuelConsumption, int fuel) {
        this.model = model;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
        this.fuel = fuel;
    };

    public abstract void accelerate();

    public abstract void brake();

    public void drive(int distance) {
        if (fuel < distance * fuelConsumption) {
            distanceCovered += fuel / fuelConsumption;
            fuel = 0;
        } else {
            fuel -= distance * fuelConsumption;
            distanceCovered += distance;
        }
    };
}