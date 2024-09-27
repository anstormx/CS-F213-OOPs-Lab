public class Engine {

    // The attributes go here
    private double horsepower;
    private double maxRPM;

    // The constructor for the Engine class
    public Engine(double horsepower, double maxRPM) {
        this.horsepower = horsepower;
        this.maxRPM = maxRPM;
    }

    // Check the UML diagrams for the method signature and the access modifiers
    public double calculateTorque(){
        return horsepower*5252/maxRPM;
    }

    // The getters go here
    public double getHorsepower(){
        return horsepower;
    }

    public double getMaxRPM(){
        return maxRPM;
    }

}