
public class PrivateFirm implements ProfitCalculation {

    @Override
    public int calculateProfit(int[] sales) {
        int maxProfit = 0;
        int currentProfit = 0;
        
        for (int sale : sales) {
            currentProfit = Math.max(0, currentProfit + sale);
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        
        return maxProfit;
    }

    
}
