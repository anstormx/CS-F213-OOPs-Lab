public class CommandProcessor {
    private String[] commands;
    private Car car;

    public void processInput(String input) {
        commands = input.split(",");

        car = createCar(commands[0].trim(), Integer.parseInt(commands[1].trim()));

        for (int i = 2; i < commands.length; i++) {
            if (commands[i].equals("accelerate")) {
                car.accelerate();
            } else {
                if (commands[i].equals("brake")) {
                    car.brake();
                } else {
                    String[] drive = commands[i].split(" ");
                    car.drive(Integer.parseInt(drive[1].trim()));
                }
            }
        }
    };

    private Car createCar(String type, int fuel) {
        if (type.equals("SportsCar")) {
            return new SportsCar(fuel);
        } else {
            if (type.equals("SUV")) {
                return new SUV(fuel);
            } else {
                return new Sedan(fuel);
            }

        }
    };

    public String getResult() {
        return car.model + " - Model: " + car.model + "\n" +
                "Final Speed: " + car.speed + " km/h\n" +
                "Fuel Remaining: " + car.fuel + "\n" +
                "Distance Covered: " + car.distanceCovered + " km";
    }
}