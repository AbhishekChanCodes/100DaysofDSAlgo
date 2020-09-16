/*

LeetCode Problem 485

Max Consecutive Ones

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:

Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.


Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

*/


/*

Approach: Keep a track of the maximum consecutive ones. Whenever you encounter a one, count the consecutive ones.
          If you encounter a 0 after 1, calculate the max consecutive ones at that stage and reset the count.
          By the end of the array, we have the number of max consecutive ones.

Time Complexity: O(n)

*/

public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxOnesCount = 0;
        int i = 0;

        while(i < nums.length) {
            if(nums[i] == 1) {
                while(i < nums.length && nums[i] == 1) {
                    i++;
                    count++;
                }
                maxOnesCount = Math.max(count, maxOnesCount);
            } else {
                i++;
                count = 0;
            }
        }

        return maxOnesCount;
}
