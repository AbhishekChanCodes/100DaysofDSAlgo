/*

LeetCode Problem 70

Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

*/


/*

This problem can be solved using a number of approaches, like dynamic programming, fibonacci series, bit manipulation etc.
I chose to solve this problem by memoization combined with recursion.

We use a helper function. We hold an array "memo" that stores the result at every step and then recursively calls itself
to calculate the results for the next steps.

I'll attempt the same problem using dynamic programming or bit manipulation on a latter day.


Time Complexity: O(n)
Space Complexity: O(n)

*/



class Solution {
    public int climbStairs(int n) {

        int memo[] = new int[n+1];
        Arrays.fill(memo,-1);
        return countWays(n,memo);
    }

    public int countWays(int n, int[] memo)
    {
        if(n < 0)
            return 0;
        else if(n == 0)
            return 1;
        else if(memo[n] > -1)
            return memo[n];
        else
        {
            memo[n] = countWays(n-1,memo) + countWays(n-2,memo);
        }

        return memo[n];
    }

}
