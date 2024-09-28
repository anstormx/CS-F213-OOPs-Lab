import java.io.*;
import java.lang.reflect.*;

public class L8_Q1_Main {

    static Class<?> ComputerScienceClass, ElectricalClass, StudentClass;

    public static Student createStudent(String name, int age, Degree degree, int[] marks) throws NoSuchMethodException {
        Constructor<?> StudentConstructor;

        try {
            StudentConstructor = StudentClass.getConstructor(String.class, int.class, Degree.class, int[].class);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodException("Student constructor not found");
        }
        Student student;

        try {
            student = (Student) StudentConstructor.newInstance(name, age, degree, marks);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            throw new IllegalArgumentException("Student constructor not found");
        }
        return student;
    }

    public static void printIfMethodExists(Class<?> cls, String methodName, Object instance, Object... args)
            throws NoSuchMethodException {
        try {
            Class<?>[] paramTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                paramTypes[i] = args[i].getClass();
            }

            // Get the method object
            Method method = cls.getMethod(methodName, paramTypes);
            method.invoke(instance, args);

        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodException("Method " + methodName + " not found in class " + cls.getSimpleName());
        } catch (Exception e) {
            System.out.println("Error while checking method " + methodName + " in class " + cls.getSimpleName());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

        /**
         * There are 5 kinds of testcases representative of the testcases T1 to T5
         * And similarly, ET1 to ET5
         * 
         * For details about the individual testcases please check each of the
         * testcases below in the switch case
         * T1- Checks if a Electrical Student contructor and getter methods are
         * implemented
         * T2- Checks if a ComputerScience Student contructor and getter methods are
         * implemented
         * T3- Checks if the Degree Electrical methods are implemented and executed
         * properly
         * T4- Checks if the Degree ComputerScience methods are implemented and executed
         * properly
         * T5- Checks if the Degree ComputerScience and Electrical methods are executed
         * properly
         */

        try {
            ComputerScienceClass = Class.forName("ComputerScience");
        } catch (ClassNotFoundException e1) {
            System.out.println("ComputerScience Class not found");
        }
        try {
            ElectricalClass = Class.forName("Electrical");
        } catch (ClassNotFoundException e2) {
            System.out.println("Electrical Class not found");
        }
        try {
            StudentClass = Class.forName("Student");
        } catch (ClassNotFoundException e2) {
            System.out.println("Student Class not found");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String input = br.readLine();
            String tokens[] = input.split(",");

            int maxStudents = 100;
            Student[] students = new Student[maxStudents];
            int studentCount = 0;

            switch (tokens[0]) {
                case "1":

                    try {
                        for (int i = 1; i < tokens.length; i++) {
                            String line = tokens[i];

                            String[] parts = line.split(" ");
                            String name = parts[0];
                            int age = Integer.parseInt(parts[1]);
                            String degreeType = parts[2];

                            int[] marks = new int[parts.length - 3];
                            for (int j = 3; j < parts.length; j++) {
                                marks[j - 3] = Integer.parseInt(parts[j]); // Marks
                            }

                            Degree degree;
                            if (degreeType.equalsIgnoreCase("ComputerScience")) {
                                degree = new ComputerScience();
                            } else if (degreeType.equalsIgnoreCase("Electrical")) {
                                degree = new Electrical();
                            } else {
                                System.out.println("Unknown degree type for student " + name);
                                continue;
                            }

                            Student student = createStudent(name, age, degree, marks);
                            students[studentCount] = student; // Store student in the array
                            studentCount++;

                            // Check and invoke methods using reflection
                            printIfMethodExists(StudentClass, "getCGPA", student);
                            printIfMethodExists(StudentClass, "getName", student);
                            printIfMethodExists(StudentClass, "getAge", student);
                            // printIfMethodExists(StudentClass, "getDegreeName", student);
                        }

                        // Filter non-null students into finalStudents array
                        Student[] finalStudents = new Student[studentCount];
                        int index = 0;
                        for (Student s : students) {
                            if (s != null) {
                                finalStudents[index++] = s;
                            }
                        }

                        // Process students using Driver
                        Driver.processStudents(finalStudents);

                    } catch (Exception e) {
                        System.out.println("Error processing data: " + e.getMessage());
                    }

                    break;

                case "2":

                    try {
                        for (int i = 1; i < tokens.length; i++) {
                            String line = tokens[i];

                            String[] parts = line.split(" ");
                            String name = parts[0]; // Student name
                            int age = Integer.parseInt(parts[1]); // Student age
                            String degreeType = parts[2]; // Degree type

                            int[] marks = new int[parts.length - 3];
                            for (int j = 3; j < parts.length; j++) {
                                marks[j - 3] = Integer.parseInt(parts[j]); // Marks
                            }

                            // Determine degree type
                            Degree degree;
                            if (degreeType.equalsIgnoreCase("ComputerScience")) {
                                degree = new ComputerScience();
                            } else if (degreeType.equalsIgnoreCase("Electrical")) {
                                degree = new Electrical();
                            } else {
                                System.out.println("Unknown degree type for student " + name);
                                continue;
                            }

                            // Create and process student directly
                            Student student;

                            student = createStudent(name, age, degree, marks);
                            students[studentCount] = student; // Store student in the array
                            studentCount++;

                            printIfMethodExists(StudentClass, "getCGPA", student);
                            printIfMethodExists(StudentClass, "getName", student);
                            printIfMethodExists(StudentClass, "getAge", student);

                        }
                        Student[] finalStudents = new Student[studentCount];
                        int index = 0;
                        for (Student student : students) {
                            if (student != null) {
                                finalStudents[index++] = student;
                            }
                        }
                        Driver.processStudents(finalStudents);
                    } catch (Exception e) {
                        System.out.println("Error processing data: " + e.getMessage());
                    }

                    break;

                case "3":

                    try {

                        for (int i = 1; i < tokens.length; i++) {
                            String line = tokens[i];

                            String[] parts = line.split(" ");
                            String name = parts[0]; // Student name
                            int age = Integer.parseInt(parts[1]); // Student age
                            String degreeType = parts[2]; // Degree type

                            int[] marks = new int[parts.length - 3];
                            for (int j = 3; j < parts.length; j++) {
                                marks[j - 3] = Integer.parseInt(parts[j]); // Marks
                            }

                            // Determine degree type
                            Degree degree;
                            if (degreeType.equalsIgnoreCase("ComputerScience")) {
                                degree = new ComputerScience();
                            } else if (degreeType.equalsIgnoreCase("Electrical")) {
                                degree = new Electrical();
                            } else {
                                System.out.println("Unknown degree type for student " + name);
                                continue;
                            }

                            // Create and process student directly
                            Student student;

                            student = createStudent(name, age, degree, marks);
                            students[studentCount] = student; // Store student in the array
                            studentCount++;

                            printIfMethodExists(ElectricalClass, "getCGPACalculation", degree, marks);
                            printIfMethodExists(ElectricalClass, "getDegreeName", degree);

                        }
                        Student[] finalStudents = new Student[studentCount];
                        int index = 0;
                        for (Student student : students) {
                            if (student != null) {
                                finalStudents[index++] = student;
                            }
                        }
                        Driver.processStudents(finalStudents);
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }

                    break;

                case "4":

                    try {

                        for (int i = 1; i < tokens.length; i++) {
                            String line = tokens[i];
                            String[] parts = line.split(" ");
                            String name = parts[0]; // Student name
                            int age = Integer.parseInt(parts[1]); // Student age
                            String degreeType = parts[2]; // Degree type

                            int[] marks = new int[parts.length - 3];
                            for (int j = 3; j < parts.length; j++) {
                                marks[j - 3] = Integer.parseInt(parts[j]); // Marks
                            }

                            // Determine degree type
                            Degree degree;
                            if (degreeType.equalsIgnoreCase("ComputerScience")) {
                                degree = new ComputerScience();
                            } else if (degreeType.equalsIgnoreCase("Electrical")) {
                                degree = new Electrical();
                            } else {
                                System.out.println("Unknown degree type for student " + name);
                                continue;
                            }

                            // Create and process student directly
                            Student student;

                            student = createStudent(name, age, degree, marks);
                            students[studentCount] = student; // Store student in the array
                            studentCount++;

                            printIfMethodExists(ComputerScienceClass, "getCGPACalculation", degree, marks);
                            printIfMethodExists(ComputerScienceClass, "getDegreeName", degree);

                        }
                        Student[] finalStudents = new Student[studentCount];
                        int index = 0;
                        for (Student student : students) {
                            if (student != null) {
                                finalStudents[index++] = student;
                            }
                        }
                        Driver.processStudents(finalStudents);
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }

                    break;

                case "5":

                    try {

                        for (int i = 1; i < tokens.length; i++) {
                            String line = tokens[i];
                            String[] parts = line.split(" ");
                            String name = parts[0]; // Student name
                            int age = Integer.parseInt(parts[1]); // Student age
                            String degreeType = parts[2]; // Degree type

                            int[] marks = new int[parts.length - 3];
                            for (int j = 3; j < parts.length; j++) {
                                marks[j - 3] = Integer.parseInt(parts[j]); // Marks
                            }

                            // Determine degree type
                            Degree degree;
                            if (degreeType.equalsIgnoreCase("ComputerScience")) {
                                degree = new ComputerScience();
                            } else if (degreeType.equalsIgnoreCase("Electrical")) {
                                degree = new Electrical();
                            } else {
                                System.out.println("Unknown degree type for student " + name);
                                continue;
                            }

                            // Create and process student directly
                            Student student;

                            student = createStudent(name, age, degree, marks);
                            students[studentCount] = student; // Store student in the array
                            studentCount++;

                        }
                        Student[] finalStudents = new Student[studentCount];
                        int index = 0;
                        for (Student student : students) {
                            if (student != null) {
                                finalStudents[index++] = student;
                            }
                        }
                        Driver.processStudents(finalStudents);
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }

                    break;
                default:
                    throw new IllegalArgumentException("Invalid input");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
