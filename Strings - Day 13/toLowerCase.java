/*

LeetCode Problem 709

To Lower Case

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"

*/




/*

This is again a very popular interview questions in this category, which is being asked to implement String library functions.

Approach: Use a StringBuilder. Parse character by character. Adding 32 to an uppercase converts it to equivalent lowercase character.

Time Complexity: O(n) where n is the length of the string.

Space Complexity: O(n)

*/


public String toLowerCase(String str) {

        StringBuilder builder = new StringBuilder();

        for(char c : str.toCharArray())
        {
            if(Character.isUpperCase(c))
            {
                char temp = (char) (c+32);
                builder.append(temp);
            }
            else
                builder.append(c);
        }

        return builder.toString();
}
