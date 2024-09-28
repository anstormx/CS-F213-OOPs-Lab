# Problem Statement

You are tasked with implementing a system to calculate and sort the profits of different companies based on their sales data. The system includes an interface, two specific firm types, and a `Company` class. You need to implement the following:

## Interface: `ProfitCalculation`

The interface contains a method `calculateProfit(int[] sales)` which calculates the profit based on the sales data provided.

## Classes that implement `ProfitCalculation`

1. **PrivateFirm**:
   - This firm calculates the largest possible profit by summing the highest sum of consecutive days' sales from the `sales` array.

2. **PublicFirm**:
   - This firm calculates the profit as the highest single-day sale from the `sales` array.

## Class: `Company`

### Attributes:
  - `String name`: The name of the company.
  - `int[] sales`: An array representing the sales made by the company on different days.
  - `ProfitCalculation calculationMethod`: The method to calculate profit.
  - `int profit`: The calculated profit of the company using either `PrivateFirm` or `PublicFirm`.

### Sorting Criteria:
  - Companies should first be sorted by their profit in descending order.
  - In case of a tie in profits, the company with fewer days of sales should be ranked higher.
