public class Student implements Comparable<Student> {
    public String name;
    public int age;
    public Degree degree;
    public int[] marks;
    public double cgpa;

    public Student(String name, int age, Degree degree, int[] marks) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.marks = marks;
        this.cgpa = degree.getCGPACalculation(marks);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDegreeName() {
        return degree.getDegreeName();
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student o) {
        double diff = o.cgpa - this.cgpa;
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        } else {
            return this.age - o.age;
        }
    }
}
