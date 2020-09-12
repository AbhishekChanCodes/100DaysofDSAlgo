/*

LeetCode Problem 242

Valid Anagram

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

*/



/*

Approach: If 2 strings are anagram of each other, it means they have the same characters with the count also being the same.
          We leverage this property. Using a HashMap, populate it with the characters and it's count from string 1.
          Later, parse through string 2 and remove the characters and decrease their counts.

          If, at the end, the hashmap is empty, the strings are anagrams, else not.

Time Complexity: O(m + n) where m and n are the lengths of the strings respectively.

Space Complexity: O(m) considering hashmap is populated with characters and counts of string with length m.

*/



public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
          return false;

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(char ch : s.toCharArray()) {
            if(map.containsKey(ch))
                map.put(ch,map.get(ch) + 1);
            else
                map.put(ch,1);
        }

        for(char ch1 : t.toCharArray()) {
            if(!map.containsKey(ch1))
                return false;
            if(map.containsKey(ch1) && map.get(ch1) > 1)
                map.put(ch1,map.get(ch1) - 1);
            else
                map.remove(ch1);

        }

        return map.size() == 0;
}
