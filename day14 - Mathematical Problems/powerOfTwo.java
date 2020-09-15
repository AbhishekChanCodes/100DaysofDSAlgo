/*

LeetCode Problem 231

Power of Two

Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false

*/



/*

Approach: Establish a base case. 1 is the 0th power of 2. All other odd numbers are not. You can eliminate them.

          Keep dividing the number by 2, until the remainder from division is not 0. If at that point, the number itself
          is 1, then it is a power of 2, else it is not.

Example:

8/2 = 4, 4/2 = 2, 2/2 = 1, eventually it becomes 1 for number which is power of 2.

12/2 = 6, 6/2 = 3. 3 % 2 != 0, so break the loop. Now n is 3, so return false.

Time Complexity: O(log n) since we are reducing the number by half at every iteration.

*/

public boolean isPowerOfTwo(int n) {

        if(n < 1)
            return false;

        if(n % 2 != 0 && n > 1)
            return false;

        while(n % 2 == 0)
        {
            n = n/2;
        }

        return n == 1;
}
