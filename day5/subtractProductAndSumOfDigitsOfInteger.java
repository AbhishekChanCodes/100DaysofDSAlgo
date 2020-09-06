/*

LeetCode Problem 1281

Subtract the Product and Sum of Digits of an Integer

Given an integer number n, return the difference between the product of its digits and the sum of its digits.


Example 1:

Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21


*/


/*

This problem is pretty straightforward and really easy. However, it is good practice to solve problems like these
to keep a hold of math and to remember what exactly the operations of "addition", "multiplication" etc actually do.

Divide the number by 10 at each step and update the sum and the product respectively. Be careful to initialize sum to 0
and product to 1 in the beginning.

Time Complexity: O(log N) where N is the number itself which we reduce by 1 digit at every step.


*/


public int subtractProductAndSum(int n) {

        int sum = 0, product = 1;

        while(n>0) {

            sum += n%10;
            product *= n%10;
            n /= 10;

        }

        return product-sum;
}
