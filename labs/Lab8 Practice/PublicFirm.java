
public class PublicFirm implements ProfitCalculation {

    @Override
    public int calculateProfit(int[] sales) {
        int profit = 0;
        for (int sale : sales) {
            if (sale > profit) {
                profit = sale;
            }
        }
        return profit;
    }

}
