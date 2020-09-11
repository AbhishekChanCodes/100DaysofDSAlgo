/*

Leetcode Problem 191

Number of 1 Bits

Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).


Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.


*/


/*

Approach: Initialize a variable count. Right shift the original number by 1 every time and if the digit is 1, increase the count.

Time Complexity: Since we are considering a 32-bit number, complexity will be O(1).

*/


// you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int count = 0;

        while(n!=0)
        {
            count += n & 1;
            n >>>= 1;
        }

        return count;
}
