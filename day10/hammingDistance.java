/*

LeetCode Problem 461

Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

*/



/*

Approach: So, we have to find the places in which the bits are different in the two numbers.
          Initially, we first XOR the two numbers, which leaves us with all the different bits from the two numbers.

          Then we simply count the number of bits in this interim result.

Time Complexity: O(n) in the worst case, assuming all bits are different.

*/

public int hammingDistance(int x, int y) {

        int differentBits = x ^ y;

        int count = 0;

        while (differentBits != 0) {
            count++;
            differentBits = differentBits & (differentBits - 1);   // This operation zeroes out any non-zero bit in the LSB.
        }

        return count;
}
