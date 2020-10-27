/*

LeetCode Problem 279

Perfect Squares

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.


Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

*/


/*

Approach: My initial approach to this was, find the square closest to and less than the given number.
          Like, for 12, start with 9 and work down. However, that led to an incorrect solution of (9,1,1,1).

          So, we start from 1 and move upwards.
          dp[n] represents how many square numbers sum up to N.
          So, dp[0] = 0, dp[1] = 1. dp[2] = dp[1] + 1 = 2, dp[3] = dp[2] + 1 = 3 and so on.

          We also find the square root of the number at each step, since the squares of the numbers after that will
          exceed the original number.

          To generalise, at each step we find dp[i] = dp[i-1] + 1, dp[i-4] + 1, dp[i-9] + 1 .........

Time Complexity: O(n * sqrt(n)) i.e. O(n)

Space Complexity: O(n)

*/


public int numSquares(int n) {

    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);

    for (int i = 1; i <= n; i++) {

        int sqrt = (int)Math.sqrt(i);

        if (sqrt * sqrt == i) {
            dp[i] = 1;
            continue;
        }

        for (int j = 1; j <= sqrt; j++) {
            int diff = i - j * j;
            dp[i] = Math.min(dp[i], (dp[diff] + 1));
        }
    }

    return dp[n];
}
