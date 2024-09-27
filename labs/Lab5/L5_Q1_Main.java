import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class L5_Q1_Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            // Read a single line of input from the console
            String input = br.readLine();
        
            // Create a CommandProcessor instance and process the input
            CommandProcessor processor = new CommandProcessor();

            try {
                processor.processInput(input);
                System.out.println(processor.getResult());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
