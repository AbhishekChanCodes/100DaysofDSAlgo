/*

LeetCode Problem 509

Fibonacci Number

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).



Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

*/



/*

Bottom-Up Approach. We know the values for 0 and 1. We use these to build up the dp array until we reach our target number N.

Time Complexity: O(N)

Space Complexity: O(N)

*/

public int fib(int N) {

        if(N == 0)
            return 0;
        if(N == 1)
            return 1;

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
}
