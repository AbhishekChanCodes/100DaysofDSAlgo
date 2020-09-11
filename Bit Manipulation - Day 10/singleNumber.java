/*

LeetCode Problem 136

Single Number

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

*/



/*

Approach: This problem can be solved in a number of ways. You can use HashMap, List etc.
          However, using bit manipulation it can be solved pretty easily.

          The trick is in the question. All other numbers occur exactly TWICE except for a single number.
          We know, that if we XOR a number with itself, the result is 0 and if we XOR a number with 0, the result
          is the number itself.

          So we initialize a variable to 0 and simply XOR it with each number in the array. At the end, all we have
          is our missing number which occurs just once.

Time Complexity: O(n) where n is the count of numbers in the array

*/


public int singleNumber(int[] nums) {

        int result = 0;

        for(int number : nums)

            result ^= number;

        return result;
}
