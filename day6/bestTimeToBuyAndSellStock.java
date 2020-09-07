/*

LeetCode Problem 121

Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/


/*

This is a very popular interview problem and it has several variations.

Initially, a brute-force approach comes to mind. All we have to do is find the greatest difference in the array,
such that the larger number occurs after the smaller number in the array. However, this has time complexity of
O(n^2).

Turns out, we don't really need brute force. We have to keep track of the minimum price and the maximum profit at
each element. After we are done parsing through the array, our maximumProfit will hold the highest possible profit.

The maximumProfit is calculated as (currentPrice - minPrice);

Time Complexity: O(n)

*/

public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for(int price : prices) {

            minPrice = Math.min(price,minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);

        }

        return maxProfit;
}
