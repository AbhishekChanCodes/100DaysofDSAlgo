/*

LeetCode Problem 344

Reverse String

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

*/



/*

This is a very popular interview question and has a number of approaches. You can use a Stack to accomplish this.

Approach: Two pointer approach. Set one poiner to beginning of string and the other to the end.
          Swap the characters, increment the pointer at the start and decrement the pointer at the end.

Time Complexity: O(n) where n is the length of the string.

*/

public void reverseString(char[] s) {

        int i = 0, j = s.length - 1;

        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
}
