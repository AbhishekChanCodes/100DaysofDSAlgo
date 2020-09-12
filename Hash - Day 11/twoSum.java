/*

LeetCode Problem 1

Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

*/


/*

Approach: Initially, I was tempted to use a HashSet. However, we don't need to return the actual elements but their indices.
          Hence, a HashSet won't work and we have to use a hashmap.

          We parse through the array. For each number, we find out it's complement i.e (target - givenNumber).
          If that number exists in the map, return the indices of both numbers, else we put the number and it's index into the hashmap.

Time Complexity: O(n)

Space Complexity: O(n)

*/

public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++) {

            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] {i,map.get(complement)};
            }
            map.put(nums[i],i);

        }

        return null;
}
