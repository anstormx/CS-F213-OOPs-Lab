public class Company implements Comparable<Company> {
    private String name;
    private int[] sales;
    private ProfitCalculation calculationMethod;
    private int profit;

    public Company(String name, int[] sales, ProfitCalculation calculationMethod) {
        this.name = name;
        this.sales = sales;
        this.calculationMethod = calculationMethod;
        this.profit = calculationMethod.calculateProfit(sales);
    }

    public String getName() {
        return name;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public int compareTo(Company o) {
        int diff = o.profit - this.profit;
        if (diff == 0) {
            return o.name.compareTo(this.name);
        }
        return diff;
    }
}
