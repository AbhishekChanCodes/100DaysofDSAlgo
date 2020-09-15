/*

LeetCode Problem 728

Self Dividing Number

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input:
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

*/


/*

Approach: Straightfoward approach. Mathematical problems are all about testing whether basic operations can be handled.
          For each number from left to right, check if it is selfDividing. Use a helper function for checking the same.

          To check if a number if self Dividing, split off 1 digit at a time. If the number is not divisible by that digit,
          or the digit is 0, return false.

          If the number is divisible by all digits, then return true.

Time Complexity:  If N is the count of numbers from left to right, then the time complexity is O(n.)
                  Since we are checking the self-dividing property for integers, the complexity for the helper function
                  will be equal to the number of digits in each number, which we know to be constant, so it is O(1).


*/


class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>();

        for(int i = left;i <= right;i++) {
            if(isSelfDividing(i)) {
                result.add(i);
            }
        }

        return result;
    }

    boolean isSelfDividing(int number) {

        int temp = number;
        while(number != 0) {
            int remainder = number%10;

            if(remainder == 0 || temp%remainder != 0)
                return false;

            number /= 10;
        }

        return true;
    }
}
