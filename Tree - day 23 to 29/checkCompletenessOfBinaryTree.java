/*

LeetCode Problem 958

Check Completeness of a Binary Tree

Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

*/



/*

Approach: Do a Level-Order Traversal using a Queue. Mark the point where you encounter the first null value.
          If you get a non-null value, after the null value, it is not a complete binary tree.
          Else, return true.

Time Complexity: O(N), since we encounter each node once.

Space Complexity: O(N) for storing inside the queue.

*/


public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        boolean lastNode = false;

        queue.add(root);

        while(!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if(current == null)
                lastNode = true;
            else {
              
                if(lastNode)
                    return false;

                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return true;
}
