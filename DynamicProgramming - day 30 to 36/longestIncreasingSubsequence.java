/*

LeetCode Problem 300

Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4

Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

*/


/*

Approach: Consider index i. The longest increasing subsequence upto i is not dependent on the remaining elements in the array.
          We initialize an array dp[], in which dp[i] is the length of the longest increasing subsequence possible
          considering the elements which we have just parsed through.

          We also keep track of these values in the dp array and we return its maximum value.

Time Complexity: O(n^2) since we have two nested for loops.

Space Complexity: O(n) where n is number of elements in the array

*/


public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;

        for (int i = 1; i < dp.length; i++) {

            int maxValue = 0;

            // If current value is greater as part of increasing subsequence, then update the maxValue.

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    maxValue = Math.max(maxValue, dp[j]);
                }
            }

            dp[i] = maxValue + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
}
