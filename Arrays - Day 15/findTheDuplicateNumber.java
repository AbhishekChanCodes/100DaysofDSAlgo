/*

LeetCode Problem 287

Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

*/

// Multiple different solutions according to constraints are given below. Brute-force with O(n^2) time is a trivial solution.


/*

Constraint: Can you solve the problem with runtime complexity less than O(n^2)?

Approach: Use a HashSet. By default, a set does not allow duplicates.
          Push all elements to set. If any element already exists, it is a duplicate. Return it.

          You can also use a copy of the array to solve with this constraint.

Time Complexity: O(n)

Space Complexity: O(n)

*/

public int findDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        for(int number : nums) {

            if(set.contains(number))
                return number;

            set.add(number);

        }

        return Integer.MAX_VALUE;
}



/*

Constaint: Can you solve the problem with runtime complexity less than O(n^2) and using only O(1) extra space?

Approach 1: Sort the array. It is very likely that an interviewer will ask you to implement your own sorting algorithm first.
            Sort the array and compare each element with it's previous. You will find the duplicate element.


Time Complexity: O(n log n) for sorting, O(n) for further finding the duplicate.
                 So, overall time complexity is O(n log n).

*/


public int findDuplicate(int[] nums) {

    Arrays.sort(nums);

    for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1])
                return nums[i];
    }

    return Integer.MAX_VALUE;
}




/*

Constraint: Can you solve the problem using only constant, O(1) extra space and in O(n) time?

Approach: Read the question carefully. We have n+1 elements and the elements are in the range [1,n].

          So, for each element we come across, we turn the element at that particular index negative.

          For eg: [1,3,4,2,2]. So, nums[nums[1]] i.e 3 will become -3.
          At every step, we check if the element is already negative. If it is, then the element is repeated.

          Be careful to use Math.abs at the appropriate places to avoid negative indexes.


Time Complexity: O(n)

*/


public int findDuplicate(int[] nums) {

        for(int i = 0; i<nums.length; i++) {

            int index = Math.abs(nums[i]);

            if(nums[index] < 0)
                return Math.abs(nums[i]);


            nums[index] = -nums[index];


        }

        return Integer.MAX_VALUE;
}
