/*

LeetCode Problem 442

Find All Duplicates in an Array

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/


/*

Approach: If you consider using extra space, then this problem is very easy. You can just use a HashSet and do it.

          How to tackle this without extra space? We read the problem statement clearly and make use of the constraint
          1 <= a[i] <= n.

          So, the index in the array run from 0 to n-1 and the numbers from 1 to n.

          So, start parsing through the array. Make the element at array[array[index]] as negative version of itself.
          At each element, we check if array[array[index]] is negative. If that is the case, then that element is repeated
          and we can add it to the result.


Time Complexity: O(n)


*/


public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {

            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] *= -1;
            else
                result.add(index + 1);

        }

        return result;
}
