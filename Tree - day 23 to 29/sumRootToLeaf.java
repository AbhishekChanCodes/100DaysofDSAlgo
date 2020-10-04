/*

LeetCode Problem 129

Sum Root to Left Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.


Example 2:
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

*/



/*

Approach: For most binary tree problems, recursion is a good place to start. For these types of problems, where we have
          to visit every node, recursion is good and makes the code very easy to read.

          Initialize a variable sum. Define a helper function, which will keep track of the cumulativeSum and recursively
          traverse through the left and right subtree and keep the sum updated.

          As we go down each level, we have to multiply the sum by 10 and then add the node value, to represent the actual number
          that will be formed by the root to leaf path.

Time Complexity: O(N), we will be visiting each node.

Space Complexity: O(N) for recursion call stack

*/


class Solution {
    public int sumNumbers(TreeNode root) {

        int sum = 0;
        return calculateSum(sum,root);
    }

    public int calculateSum(int sum, TreeNode root) {

        if(root == null)
            return 0;

        sum = (sum * 10) + root.val;

        if(root.left == null && root.right == null)
            return sum;

        return calculateSum(sum,root.left) + calculateSum(sum,root.right);
    }
}
