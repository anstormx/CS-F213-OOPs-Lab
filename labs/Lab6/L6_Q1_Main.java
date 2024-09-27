import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.*;

public class L6_Q1_Main {

    static Class<?> engineClass, carClass;

    public static Engine createEngine(double hp, double rpm) throws NoSuchMethodException {
        Constructor<?> engineConstructor;
        // Looking for the constructor
        try {
            engineConstructor = engineClass.getConstructor(double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodException("Engine constructor not found");
        }
        Engine engine;
        // Calling the constructor
        try{
            engine = (Engine) engineConstructor.newInstance(hp, rpm);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new IllegalArgumentException("Engine constructor not found");
        }
        return engine;
    }

    public static Car createCar(double weight, double dragCoefficient, double frontalArea, double hp, double rpm) throws NoSuchMethodException {
        Constructor<?> carConstructor;
        Engine engine = createEngine(hp, rpm);
        Car car;

        // Looking for the constructor
        try {
            carConstructor = carClass.getConstructor(double.class, double.class, double.class, Engine.class);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodException("Car constructor not found");
        }
        // Calling the constructor
        try{
            car = (Car) carConstructor.newInstance(weight, dragCoefficient, frontalArea, engine);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new IllegalArgumentException("Car constructor not found");
        }
        return car;
    }

    public static void printIfMethodExists(Class<?> cls, String methodName, Object instance, Object... args){
        try{
            Class<?>[] paramTypes = new Class[args.length];
            for(int i = 0; i < args.length; i++){
                paramTypes[i] = args[i].getClass();
            }

            // Get the method object
            Method method = cls.getMethod(methodName, paramTypes);
            Object result = method.invoke(instance, args);

            // Print the result
            if(result != null) System.out.println(result);

        } catch (NoSuchMethodException e) {
            System.out.println("Method " + methodName + " not found");
        } catch (Exception e) {
            System.out.println("Error while checking method " + methodName);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

        // Checking if the Engine and Car classes are present
        try{
            engineClass = Class.forName("Engine");
        } catch (ClassNotFoundException e1) {
            System.out.println("Engine Class not found");
        }
        try{
            carClass = Class.forName("Car");
        } catch (ClassNotFoundException e2) {
            System.out.println("Car Class not found");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            // Read a single line of input from the console
            String input = br.readLine();
            String tokens[] = input.split(",");

            /**
             * There are 5 kinds of testcases representative of the testcases T1 to T5
             * And similarly, ET1 to ET5
             * 
             * For details about the individual testcases please check each of the
             * testcases below in the switch case
             * 
             */
            
            double hp, rpm, weight, dragCoefficient, frontalArea,increaseSpeedBy;
            Engine engine;
            Car car;
            Method accelerate;

            switch (tokens[0]) {
                case "1":
                    // Checking the Engine class constructor and getters
                    hp = Double.parseDouble(tokens[1]);
                    rpm = Double.parseDouble(tokens[2]);

                    // Creating an Engine object
                    engine = createEngine(hp, rpm);

                    // Checking the getters
                    printIfMethodExists(engineClass, "getHorsepower", engine);
                    printIfMethodExists(engineClass, "getMaxRPM", engine);

                    break;

                    
                case "2":
                // Checking the Engine class calculateTorque method

                    // Checking the first sub-testcase
                    hp = Double.parseDouble(tokens[1]);
                    rpm = Double.parseDouble(tokens[2]);
                    engine = createEngine(hp, rpm);
                    // Checking the calculateTorque method
                    printIfMethodExists(engineClass, "calculateTorque", engine);


                    // Checking the second sub-testcase
                    hp = Double.parseDouble(tokens[3]);
                    rpm = Double.parseDouble(tokens[4]);
                    engine = createEngine(hp, rpm);
                    // Checking the calculateTorque method
                    printIfMethodExists(engineClass, "calculateTorque", engine);

                    break;


                case "3":
                // Checking the Car class constructor and getters and the accelerate method
                    weight = Double.parseDouble(tokens[1]);
                    dragCoefficient = Double.parseDouble(tokens[2]);
                    frontalArea = Double.parseDouble(tokens[3]);
                    hp = Double.parseDouble(tokens[4]);
                    rpm = Double.parseDouble(tokens[5]);
                    car = createCar(weight, dragCoefficient, frontalArea, hp, rpm);


                    // Checking the getters
                    printIfMethodExists(carClass, "getWeight", car);
                    printIfMethodExists(carClass, "getDragCoefficient", car);
                    printIfMethodExists(carClass, "getFrontalArea", car);
                    printIfMethodExists(carClass, "getSpeed", car);

                    increaseSpeedBy = Double.parseDouble(tokens[6]);
                    // Calling the accelerate method
                    accelerate = carClass.getMethod("accelerate", double.class);
                    accelerate.invoke(car, increaseSpeedBy);
                    // Checking speed
                    printIfMethodExists(carClass, "getSpeed", car);                    

                    break;


                case "4":
                // Checking the Car class calculateDragForce
                    weight = Double.parseDouble(tokens[1]);
                    dragCoefficient = Double.parseDouble(tokens[2]);
                    frontalArea = Double.parseDouble(tokens[3]);
                    hp = Double.parseDouble(tokens[4]);
                    rpm = Double.parseDouble(tokens[5]);
                    car = createCar(weight, dragCoefficient, frontalArea, hp, rpm);
                    increaseSpeedBy = Double.parseDouble(tokens[6]);
                    // Calling the accelerate method
                    accelerate = carClass.getMethod("accelerate", double.class);
                    accelerate.invoke(car, increaseSpeedBy);
                    // Checking the drage force
                    printIfMethodExists(carClass, "calculateDragForce", car);

                    // Checking the second sub-testcase
                    weight = Double.parseDouble(tokens[7]);
                    dragCoefficient = Double.parseDouble(tokens[8]);
                    frontalArea = Double.parseDouble(tokens[9]);
                    hp = Double.parseDouble(tokens[10]);
                    rpm = Double.parseDouble(tokens[11]);
                    car = createCar(weight, dragCoefficient, frontalArea, hp, rpm);
                    increaseSpeedBy = Double.parseDouble(tokens[12]);
                    // Calling the accelerate method
                    accelerate = carClass.getMethod("accelerate", double.class);
                    accelerate.invoke(car, increaseSpeedBy);
                    // Checking the drage force
                    printIfMethodExists(carClass, "calculateDragForce", car);

                    break;


                case "5":
                    // Checking the Car class calculateAcceleration and the engine torque
                    weight = Double.parseDouble(tokens[1]);
                    dragCoefficient = Double.parseDouble(tokens[2]);
                    frontalArea = Double.parseDouble(tokens[3]);
                    hp = Double.parseDouble(tokens[4]);
                    rpm = Double.parseDouble(tokens[5]);
                    engine = createEngine(hp, rpm);
                    car = createCar(weight, dragCoefficient, frontalArea, hp, rpm);

                    // Checking torque
                    printIfMethodExists(engineClass, "calculateTorque", engine);
                    // Checking acceleration
                    printIfMethodExists(carClass, "calculateAcceleration", car);


                    // Checking the second sub-testcase
                    weight = Double.parseDouble(tokens[6]);
                    dragCoefficient = Double.parseDouble(tokens[7]);
                    frontalArea = Double.parseDouble(tokens[8]);
                    hp = Double.parseDouble(tokens[9]);
                    rpm = Double.parseDouble(tokens[10]);
                    engine = createEngine(hp, rpm);
                    car = createCar(weight, dragCoefficient, frontalArea, hp, rpm);

                    // Checking torque
                    printIfMethodExists(engineClass, "calculateTorque", engine);
                    // Checking acceleration
                    printIfMethodExists(carClass, "calculateAcceleration", car);

                    break;

                default:
                    throw new IllegalArgumentException("Invalid input");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

