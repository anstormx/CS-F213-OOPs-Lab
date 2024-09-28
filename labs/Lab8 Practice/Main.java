
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /* Testcase */

        ProfitCalculation privateFirmCalc = new PrivateFirm();
        ProfitCalculation publicFirmCalc = new PublicFirm();

        Company[] companies = {
                new Company("PrivateFirmA", new int[] { 100, -50, 60, -50 }, privateFirmCalc),
                new Company("PublicFirmB", new int[] { -20, 10, -30, 50 }, publicFirmCalc),
                new Company("PrivateFirmC", new int[] { 50, -20, 30, -30 }, privateFirmCalc),
                new Company("PublicFirmD", new int[] { 10, -40, 50 }, publicFirmCalc)
        };

        /* Understand what sort does */
        Arrays.sort(companies);

        /*
         * Implement the getter functions to print the output.
         */

        System.out.println("Sorted Companies by Profit and Sales:");
        for (Company company : companies) {
            System.out.println("Name: " + company.getName() + ", profit: " +
                    company.getProfit());
        }
        /*
         * Expected Outout:
         * Sorted Companies by Profit and Sales:
         * Name: PrivateFirmA, profit: 110
         * Name: PrivateFirmC, profit: 60
         * Name: PublicFirmD, profit: 50
         * Name: PublicFirmB, profit: 50
         */
    }
}
