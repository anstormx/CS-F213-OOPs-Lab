import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class L4_Q1_Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            //System.out.println("Enter text (press Enter without typing to finish):");
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                TextAnalyzer solution = new TextAnalyzer(line);
                solution.solve();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}