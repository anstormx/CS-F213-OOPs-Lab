import java.util.Arrays;

public class Driver {

    public static void processStudents(Student[] students) {

        Arrays.sort(students);

        for (Student student : students) {
            if (student != null) {
                System.out.println("Name: " + student.name);
                System.out.println("Age: " + student.age);
                System.out.println("CGPA: " + String.format("%.3f", student.cgpa));

            }
        }
    }
}
