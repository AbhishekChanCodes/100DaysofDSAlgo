/*

LeetCode Problem 103

Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

*/



/*

This is a classic interview question. If you do recursive/iterative, the interviewer may ask you to implement
the other approach as a follow-up.

My Approach: Binary Tree problems like these are a classic case to use RECURSION to solve the problem.
             Also, you try to find "False" cases first. If at some point, the tree is not symmetric then just
             return false and end the computation. No need to solve it further.

             If all conditions are satisfied, then we can return true.

Time Complexity: O(n)

Space Complexity: No additional space, but stack can reach up to O(n) complexity due to recursive calls in the worst case.

Alternative iterative approach: You can use a Queue and BFS to avoid recursion. Start with inserting root twice into the queue.
                                Then move along left and right subtrees to compare the appropriate nodes for symmetry.


Time Complexity: O(n)

Space Complexity: O(n)

*/



// Recursive Approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2)
    {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;

        return (t1.val == t2.val)
            && isMirror(t1.left,t2.right)
            && isMirror(t1.right,t2.left);

    }
}

// Iterative Approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      queue.add(root);
      while (!queue.isEmpty()) {
        TreeNode t1 = queue.poll();
        TreeNode t2 = queue.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        queue.add(t1.left);
        queue.add(t2.right);
        queue.add(t1.right);
        queue.add(t2.left);
      }
      return true;
    }
}
