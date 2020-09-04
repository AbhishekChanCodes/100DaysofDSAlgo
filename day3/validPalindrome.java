/*

LeetCode Problem 125

Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

Constraints:

s consists only of printable ASCII characters.

*/


/*

This problem can be solved by a number of approaches. You can use a stack. You can reverse the string and compare it to
the original.

However, as we can see in the given examples, we also have special characters to deal with like whitespacecs and punctuations.

In my approach, I have first used a library function to remove all special characters from the string except characters and digits.
Then we convert the string to lower case.

Next, you initialize two pointers, from start of string and from end of string.
You compare the characters, advance 1 pointer and decrease the other. If at any point the characters are not equal, return false.
Do this until the starting pointer <= ending pointer.

Time Complexity: O(n) since each character in string is traversed exactly once.

*/

public boolean isPalindrome(String s) {

        String result = s.replaceAll("[^a-zA-Z0-9]", "");

        if(result.length() == 0)
            return true;

        result = result.toLowerCase();

        int i=0,j=result.length() - 1;

        while(i<=j) {

            if(result.charAt(i) != result.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
}
