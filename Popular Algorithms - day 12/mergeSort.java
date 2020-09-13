/*

MergeSort.

It is a divide and conquer algorithm.

It comprises of 2 major steps:

1. Divide the given unsorted array into multiple subarrays, each of size 1.

2. Merge the sorted subarrays repeatedly to form sorted subarrays and eventually get the whole final sorted array.


Time Complexity: The time complexity for mergesort is O(n log n).

*/


class Solution {

  public static void merge(int[] array, int low, int mid, int high) {

    int leftIndex = mid - low + 1;
    int rightIndex=  high - mid;

    // Creating temporary subarrays
    int leftArray = new int[leftIndex];
    int rightArray = new int[rightIndex];

    for(int i = 0;i < left;i++)
      leftArray[i] = array[low + i];

    for(int j = 0;j<right;j++)
      rightArray[i] = array[mid + 1 + j];

    int i = 0, j = 0, k = low;

    // Comparing the elements and placing them in their proper position in the array.
    while(i < leftIndex && j < rightIndex) {

      if(leftArray[i] <= rightArray[j]) {

          array[k] = leftArray[i];
          i++;
      } else {

          array[k] = rightArray[j];
          j++;
      }
      k++;
    }

    // Copying the remaining elements from left Subarray
    while(i < leftIndex) {

      arr[k] = leftArray[i];
      i++;
      k++;
    }

    // Copying the remaining elements from right Subarray
    while(j < rightIndex) {

      arr[k] = rightArray[j];
      j++;
      k++;
    }

  }

  public static void mergeSort(int[] array, int low, int high) {

    if(low < high) {

      int mid = low + (high - low)/2;
      mergeSort(array, low, mid);
      mergeSort(array, mid + 1, high);
      merge(array, low, mid, high);

    }
    else
      return;
  }

  public static void main(String args[]) {

    int[] array = {40,50,10,90,20,80,30,100};

    mergeSort(array, 0, array.length - 1);

  }

}
