public class Electrical implements Degree {

    private final String degreeName = "Electrical";

    @Override
    public double getCGPACalculation(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        double cgpa = (double) sum / marks.length;
        return cgpa;
    }

    @Override
    public String getDegreeName() {
        return degreeName;
    }

}
