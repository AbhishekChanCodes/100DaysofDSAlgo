/*

LeetCode Problem 27

Remove Element

Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.


Example 2:
Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.

*/


/*

Approach: We don't care about what elements are left beyond the new length of the array. We can take advantage of this constraint.
          Initialize a pointer newLength to 0. Parse through the elements in the array. If a number is not the given number val,
          write that number to array[newLength] and increment the pointer.

          Eventually, after parsing through the array, the pointer newLength has reached it's desired destination. Return it.

Note: This solution is possible because of the given constraint. If the problem says, all elements beyond newLength must be val,
      we will need to adopt a different approach. I have included that approach as well.

Time Complexity: O(n)

*/


// Considering given constraint, that values beyond newLength do not matter.
public int removeElement(int[] nums, int val) {

        int newLength = 0;

        for(int number : nums) {

            if(number != val) {

                nums[newLength] = number;
                newLength++;
            }
        }

        return newLength;
}



/* Generic problem: We have to leave the values beyond newLength as val
   This approach uses two passes. We count the number of vals in the first quick pass.
   In the second pass, we initialize a pointer "i" to start and "j" to end of array.
   When array[i] == val and array[j] != val, we swap the two.
   Continue this process, until i < j.

   In the end, all vals will be beyond the newLength.


Time Complexity: O(n)

*/
public int removeElement(int[] nums, int val) {

        int countOfVal = 0;

        for(int number : nums) {

            if(number == val)
                countOfVal++;
        }

        if(countOfVal == nums.length)
            return 0;

        if(countOfVal == 0)
            return nums.length;


        int i = 0, j = nums.length - 1;

        while(i < j) {

            while(nums[j] == val)
                j--;

            while(nums[i] != val)
                i++;

            if(i >= j)
                break;

            if(nums[i] == val && nums[j] != val) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;

            }

        }

        return nums.length - countOfVal;
}
