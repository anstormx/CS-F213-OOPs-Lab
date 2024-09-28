import java.util.Arrays;

public class ComputerScience implements Degree {
    private final String degreeName = "Computer Science";

    @Override
    public double getCGPACalculation(int[] marks) {
        int[] sum = new int[3];

        for (int i = 0; i < 3; i++) {
            sum[i] = marks[i] + marks[i + 1] + marks[i + 2];
        }

        Arrays.sort(sum);

        return (double) (sum[2]) / 3;
    }

    @Override
    public String getDegreeName() {
        return degreeName;
    }

}
