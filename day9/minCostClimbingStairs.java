/*

LeetCode Problem 746

Min Cost Climbing Stairs

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

*/



/*

Approach: We can start at step 0 and 1. After that, we have to make the minimum cost choice between the next two steps i.e. Math.min(i+1,i+2);
          We add it to the cumulative cost.

          For the last step, we should be left with either 2 steps to reach the end or 1 step. Based upon the costs of those steps, we return the final result.


Time Complexity: O(n) where n is the number of steps.

Space Complexity: O(n)        

*/

public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {

            if(i < 2)
                dp[i] = cost[i];
            else
                dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }

        return Math.min(dp[n-1],dp[n-2]);
}
