public class Car {

    // The attributes go here
    private double weight;
    private double dragCoeffcient;
    private double frontalArea;
    private double speed;
    private Engine engine;

    // The constructor for the Car class
    public Car(double weight, double dragCoeffcient, double frontalArea, Engine engine) {
        this.weight = weight;
        this.dragCoeffcient = dragCoeffcient;
        this.frontalArea = frontalArea;
        this.engine = engine;
        this.speed = 0;
    }

    // Check the UML diagrams for the method signature and the access modifiers
    public void accelerate(double increaseSpeedBy) {
        speed += increaseSpeedBy;
    }

    public double calculateDragForce() {
        return 0.5 * dragCoeffcient * frontalArea * Math.pow(speed,2);
    }

    public double calculateAcceleration() {
        double torque = engine.calculateTorque();
        return torque * 746 / (weight * 9.81);
    }

    // The getters go here
    public double getWeight(){
        return weight;
    }

    public double getDragCoefficient(){
        return dragCoeffcient;
    }

    public double getFrontalArea(){
        return frontalArea;
    }

    public double getSpeed(){
        return speed;
    }

}