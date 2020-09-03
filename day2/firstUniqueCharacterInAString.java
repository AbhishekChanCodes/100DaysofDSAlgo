/*

LeetCode Problem 387

First Unique Character in a String

Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.

*/



/*

Approach: Use a HashMap and parse over the input string. Store each character and it's count in the map.

Parse over the string a second time and identify their values. The first character for which value is 1 will be your answer.

HashMap has O(1) insertion and retrieval so this operation is not very heavy on compute time.

Time Complexity: O(n)

Space Complexity: O(n). If the problem specifies only a specific set of characters, like English characters or Greek characters,
                  then space complexity will be O(1) since you only have a fixed number of entries in the map.

*/

public int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(char ch : s.toCharArray()) {

            if(!map.containsKey(ch)) {
                map.put(ch,1);
            } else {
                map.put(ch, map.get(ch)+1);
            }

        }

        for(int i=0;i<s.length();i++) {

            if(map.get(s.charAt(i)) == 1)
                return i;

        }

        return -1;

}
