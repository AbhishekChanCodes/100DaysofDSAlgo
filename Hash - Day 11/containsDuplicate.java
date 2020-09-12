/*

LeetCode Problem 217

Contains Duplicate

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

*/


/*

Approach: This problem can be solved in a number of ways including brute-force linear search, sorting etc.
          However, using a hash based data structure is a great way to reduce time complexity in favor of some additional space,
          since insertion and retrieval in these data structures is O(1) time
          They are a great choice for finding duplicates or similar category of problems.

          I have chosen a HashSet here. A hashset doesn't allow duplicate elements. Insert all elements into the set.
          The moment you find an element which already exists in the set, return true.

Time Complexity: O(n)

Space Complexity: O(n)

*/
public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        for(int number : nums) {

            if(set.contains(number))
                return true;

            set.add(number);
        }

        return false;
}
