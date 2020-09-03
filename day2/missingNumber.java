/*

LeetCode Problem 268

Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8

*/


/*

This problem can be solved in a number of ways. Using sorting, using Sets. I have included 2 approaches here.

Approach 1 : Since we know the array will only contain elements from 0 to n, by use of the mathematical formula for summation
             we can find the missing number


Approach 2: Using bit manipulation. Initialize a variable to length of the array.
            Then looping through the array, we XOR it with each index and each element. Finally, we will be left
            with the missing number in the array.


Time Complexity for both approaches: O(n)

*/


public int missingNumber(int[] nums) {
      /*

      Approach 1: Using mathematical formula for summation

        int n = nums.length;
        int totalSum = (n * (n+1))/2;
        int actualSum = 0;

        for(int number : nums)
            actualSum += number;

        return totalSum - actualSum;
      */


        // Approach 2: Using XOR
        int missingNumber = nums.length;

        for(int i=0;i<nums.length;i++) {
            missingNumber ^= i ^ nums[i];
        }

        return missingNumber;

}
