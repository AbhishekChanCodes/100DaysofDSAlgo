/*

Like MergeSort, quickSort is a divide and conquer algorithm. However, it has 1 advantage over mergesort that is,
this algorithm sorts the array in-place and is especially useful when the array size is significantly large.

It has 3 main steps.

1. Choose the pivot element. This is a crucial step. If you choose the pivot poorly, your algorithm's runtime may be
   affected adversely. Usually, the first or the last elements in the input array are chosen as pivots.

2. Partition: Organize the array, such that all elements lesser than the pivot come before it and all the elements
              greater than the pivot come after it.

3. Recursively apply the above steps to both left and right subarrays, until the entire array is sorted.


Time Complexity: It is usually O(n log n) in the average case.
                 However, in the worse case, i.e. the array is already sorted in either ascending or descending order,
                 quicksort takes exponential time and it's complexity is O(n ^ 2). This is a rare situation.

*/




class Solution {

  public static int partition(int[] array, int low, int high) {

    int pivot = array[high];

    int i = low - 1;

    for(int j = low; j < high; j++) {

      // If element is less than pivot
      if(array[j] < pivot) {

        i++;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    // Place the pivot at it's appropriate position.
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }

  public static void quickSort(int[] array, int low, int high) {

    if(low >= high)
      return;

    // Choose the pivot and partition the array.
    int pivot = partition(array, low, high);

    // Recursively sort the left and right subarrays created after partitioning.
    quickSort(array, start, pivot - 1);
    quickSort(array, pivot + 1, end);

  }

  public static void main(String[] args) {

    int[] array = {40,50,10,90,20,80,30,100};

    quickSort(array, 0, array.length - 1);
  }

}
