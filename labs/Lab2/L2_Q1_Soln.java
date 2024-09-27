import java.util.Arrays;

public class L2_Q1_Soln {

    static void solve(int[] inputArr) {
        float sum = 0;

        Arrays.sort(inputArr);

        float first = inputArr[inputArr.length - 1];
        float sec = inputArr[inputArr.length - 2];

        for (int num : inputArr) {
            sum += num;
        }

        float avg = (float) (sum) / inputArr.length;
        System.out.println(first + " " + sec + " " + avg);
    }
}