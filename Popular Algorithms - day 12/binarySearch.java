/*

Binary Search

Given a sorted array and a target value, find if the target exists in the array or not.

Example 1:

Array = [2,4,6,8,10] target = 6
Result: Element exists at index 2


Example 2:
Array = [1,2,3,4,5,6,7,8,9] target = 10
Result: Element does not exist in the array

*/



/*

To search for the target value in the array in O(n) time is a trivial task.
However, we have been provided with some more information i.e. the array is sorted. How can we use this information
to reduce the time complexity?

We use a technique called divide and conquer.
We pick the middle element of the array and compare it to the target. If the target is lesser than middle element,
then search the left subarray, else search the right subarray. Do this, until we find the target or until we can't search
any more and we conclude that the target element does not exist in the array.

With larger inputs, we can see the difference between number of computations in binary search and linear search.

We can do this using both recursion and iteration.

Time Complexity: O(log n). This is because, at each step, our search space is exactly half of the previous one.

Space Complexity: Iterative way: O(1)
                  Recursive way: O(log n), because of the call stack

*/



// Iterative Implementation

class Solution {

  public static int binarySearch(int[] array, int target) {

    int low = 0, high = array.length - 1;

    while(low <= high) {

      int mid = low + (high - low) / 2;      // Avoid integer overflow.

      if(target == array[mid])
        return mid;

      else if(target < array[mid])
        high = mid - 1;

      else
        low = mid + 1;
    }

    return -1;
  }

  public static void main(String args[]) {

    int[] array = new int[1,2,3,4,5,6,7,8,9];
    int target = 8;

    int result = binarySearch(array,target);

    if(result > 0)
      System.out.print("Element exists at position "+result);
    else
      System.out.print("Element does not exist in the array");
  }
}





/*

Recursive Implementation : I have done it with the use of a helper function, however, you can skip it and just calculate
                           low and high from main and use those paramenters in a single binarySearch function.

*/

class Solution {

  public static int binarySearch(int[] array, int target) {

    int low = 0, high = array.length - 1;

    return binSearch(array, target, low, high);
  }

  public static int binSearch(int[] array, int target, int low, int high) {

    // Condition to terminate recursion when there is no more search space left.
    if(left > right)
      return -1;

    int mid = low + (high - low) / 2;

    if(target == array[mid])
      return mid;

    else if(target < array[mid])
      return binSearch(array, target, low, mid - 1);

    else
      return binSearch(array, target, mid + 1, high);
  }

  public static void main(String args[]) {

    int[] array = new int[1,2,3,4,5,6,7,8,9];
    int target = 10;

    int result = binarySearch(array,target);

    if(result > 0)
      System.out.print("Element exists at position "+result);
    else
      System.out.print("Element does not exist in the array");
  }
}
