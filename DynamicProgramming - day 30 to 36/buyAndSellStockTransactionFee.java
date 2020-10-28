/*

LeetCode Problem 714

Best Time To Buy And Sell Stock With Transaction Fee

You are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

*/



/*

Approach: For each price, we find the profit if we had bought the stock at that point and also the profit if we didn't
          buy a stock at that point.

          For the first value, the profit with no stock is negative of the first value.

          Then, at each point, we decide to choose the maximum possible values of both profits, after adding the
          price at that point and subtracting the transaction fee.


Time Complexity: O(n)

*/



public int maxProfit(int[] prices, int fee) {

        int maxProfitWithStock = 0;
        int noStock = -prices[0];

        for(int i = 1; i < prices.length; i++) {

            maxProfitWithStock = Math.max(maxProfitWithStock, noStock + prices[i] - fee);

            noStock = Math.max(noStock, maxProfitWithStock - prices[i]);

        }
        return maxProfitWithStock;
}
