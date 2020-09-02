/*

LeetCode Problem 108

Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*/

/*

My Approach : With problems like these, it is helpful to understand what exactly does a binary search tree mean.
              Using the BST property of numbers less than root in left subtree and greater than root in right subtree,
              we can recursively construct the BST from the given sorted array.

              Since the array is sorted, we pick the middle element as root and then recursively construct both subtrees.


Time Complexity: O(n) since each element in the sorted array is visited once.

*/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        return helper(nums,left,right);

    }

    private TreeNode helper(int[] nums, int left, int right)
    {
        if(left>right)
            return null;

        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);

        return root;
    }

}
